package bm.it.mobile.connector.sample.presenter

import bm.it.mobile.connector.sample.model.UriModel
import bm.it.mobile.connector.sample.model.UserModel

interface ISamplePresenter {
    fun print(model: UserModel)
    fun print(model: UriModel)
    fun showError()
}