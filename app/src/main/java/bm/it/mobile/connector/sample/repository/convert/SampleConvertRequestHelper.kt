package bm.it.mobile.connector.sample.repository.convert

import bm.it.mobile.connector.sample.model.UpdateUserModel
import bm.it.mobile.connector.sample.repository.model.request.CreateUserRequest
import bm.it.mobile.connector.sample.repository.model.request.UpdateUserRequest

class SampleConvertRequestHelper {

    companion object {

        fun convertToCreateUserRequest(model: UpdateUserModel): CreateUserRequest {
            return CreateUserRequest(
                name = model.firstName,
                job = model.job
            )
        }

        fun convertToUpdateUserRequest(model: UpdateUserModel): UpdateUserRequest {
            return UpdateUserRequest(
                name = model.firstName,
                job = model.job
            )
        }
    }
}