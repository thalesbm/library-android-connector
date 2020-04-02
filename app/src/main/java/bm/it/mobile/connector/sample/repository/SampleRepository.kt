package bm.it.mobile.connector.sample.repository

import bm.it.mobile.connector.library.ConnectorApplication
import bm.it.mobile.connector.library.IConnectorCallback
import bm.it.mobile.connector.library.IRepositoryCallback
import bm.it.mobile.connector.library.rest.response.ConnectorFailureResponse
import bm.it.mobile.connector.library.rest.response.ConnectorSuccessResponse
import bm.it.mobile.connector.sample.SampleURL
import bm.it.mobile.connector.sample.model.UserModel
import com.google.gson.Gson

class SampleRepository(private val connector: ConnectorApplication) : ISampleRepository {

    override fun getUsers(callback: IRepositoryCallback<UserModel>) {
        connector.configureRequest().get(SampleURL.GET, object : IConnectorCallback {
            override fun onSuccess(successResponse: ConnectorSuccessResponse) {
                val gson = Gson()
                callback.onSuccess(gson.fromJson(successResponse.json, UserModel::class.java))
            }
            override fun onFailure(failureResponse: ConnectorFailureResponse) {
                callback.onFailure()
            }
        })
    }
}