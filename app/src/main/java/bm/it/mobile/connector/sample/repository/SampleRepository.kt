package bm.it.mobile.connector.sample.repository

import bm.it.mobile.connector.library.ConnectorApplication
import bm.it.mobile.connector.library.IConnectorCallback
import bm.it.mobile.connector.library.IRepositoryCallback
import bm.it.mobile.connector.library.response.ConnectorFailureResponse
import bm.it.mobile.connector.library.response.ConnectorSuccessResponse
import bm.it.mobile.connector.sample.SampleURL
import bm.it.mobile.connector.sample.model.UpdateUserModel
import bm.it.mobile.connector.sample.model.UserModel
import bm.it.mobile.connector.sample.repository.convert.SampleConvertRequestHelper
import bm.it.mobile.connector.sample.repository.convert.SampleConvertResponseHelper
import bm.it.mobile.connector.sample.repository.model.response.CreateUserResponse
import bm.it.mobile.connector.sample.repository.model.response.GetUserResponse
import bm.it.mobile.connector.sample.repository.model.response.UpdateUserResponse
import com.google.gson.Gson

class SampleRepository(private val connector: ConnectorApplication) : ISampleRepository {

    private var gson: Gson = Gson()

    override fun getUsers(callback: IRepositoryCallback<UserModel>) {
        connector.configureRequest().get(SampleURL.GET, object : IConnectorCallback {
            override fun onSuccess(successResponse: ConnectorSuccessResponse) {
                val response = gson.fromJson(successResponse.json, GetUserResponse::class.java)
                val model = SampleConvertResponseHelper.convertToModel(response)
                callback.onSuccess(model)
            }

            override fun onFailure(failureResponse: ConnectorFailureResponse) {
                callback.onFailure()
            }
        })
    }

    override fun postUser(model: UpdateUserModel, callback: IRepositoryCallback<UserModel>) {
        val request = SampleConvertRequestHelper.convertToCreateUserRequest(model)
        val json = gson.toJson(request)

        connector.configureRequest().post(SampleURL.POST, json, object : IConnectorCallback {
            override fun onSuccess(successResponse: ConnectorSuccessResponse) {
                val response = gson.fromJson(successResponse.json, CreateUserResponse::class.java)
                val model = SampleConvertResponseHelper.convertToModel(response)
                callback.onSuccess(model)
            }

            override fun onFailure(failureResponse: ConnectorFailureResponse) {
                callback.onFailure()
            }
        })
    }

    override fun putUser(model: UpdateUserModel, callback: IRepositoryCallback<UserModel>) {
        val request = SampleConvertRequestHelper.convertToUpdateUserRequest(model)
        val json = gson.toJson(request)

        connector.configureRequest().put(SampleURL.PUT, json, object : IConnectorCallback {
            override fun onSuccess(successResponse: ConnectorSuccessResponse) {
                val response = gson.fromJson(successResponse.json, UpdateUserResponse::class.java)
                val model = SampleConvertResponseHelper.convertToModel(response)
                callback.onSuccess(model)
            }

            override fun onFailure(failureResponse: ConnectorFailureResponse) {
                callback.onFailure()
            }
        })
    }
}