package bm.it.mobile.connector.sample.repository

import bm.it.mobile.connector.library.IRepositoryCallback
import bm.it.mobile.connector.sample.model.UriModel
import bm.it.mobile.connector.sample.model.UserModel

interface ISampleRepository {

    fun getUsers(callback: IRepositoryCallback<UserModel>)

    fun postUser(model: UserModel, callback: IRepositoryCallback<UriModel>)

    fun putUser(model: UserModel, callback: IRepositoryCallback<UriModel>)
}