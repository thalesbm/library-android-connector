package bm.it.mobile.connector.sample.repository.convert

import bm.it.mobile.connector.sample.model.UserModel
import bm.it.mobile.connector.sample.repository.model.response.CreateUserResponse
import bm.it.mobile.connector.sample.repository.model.response.GetUserResponse
import bm.it.mobile.connector.sample.repository.model.response.UpdateUserResponse

class SampleConvertResponseHelper {

    companion object {

        fun convertToModel(response: GetUserResponse): UserModel {
            return UserModel(
                id = response.userModel.id,
                email = response.userModel.email,
                firstName = response.userModel.firstName,
                lastName = response.userModel.lastName
            )
        }

        fun convertToModel(response: CreateUserResponse): UserModel {
            return UserModel(
                firstName = response.name,
                job = response.job
            )
        }

        fun convertToModel(response: UpdateUserResponse): UserModel {
            return UserModel(
                firstName = response.name,
                job = response.job
            )
        }
    }
}