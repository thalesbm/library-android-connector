package bm.it.mobile.connector.sample.repository

import bm.it.mobile.connector.library.IRepositoryCallback
import bm.it.mobile.connector.sample.model.UpdateUserModel
import bm.it.mobile.connector.sample.model.UserModel

interface ISampleRepository {

    fun getUsers(callback: IRepositoryCallback<UserModel>)

    fun postUser(model: UpdateUserModel, callback: IRepositoryCallback<UserModel>)

    fun putUser(model: UpdateUserModel, callback: IRepositoryCallback<UserModel>)
}