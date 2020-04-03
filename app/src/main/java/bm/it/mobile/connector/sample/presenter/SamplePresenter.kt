package bm.it.mobile.connector.sample.presenter

import bm.it.mobile.connector.sample.model.UserModel
import bm.it.mobile.connector.sample.view.ISampleView

class SamplePresenter(private val view: ISampleView) : ISamplePresenter {

    override fun print(model: UserModel) {
        view.print(model.firstName)
    }

    override fun showError() {
        view.showError()
    }
}