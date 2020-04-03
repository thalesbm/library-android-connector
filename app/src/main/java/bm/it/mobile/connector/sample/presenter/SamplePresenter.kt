package bm.it.mobile.connector.sample.presenter

import bm.it.mobile.connector.sample.view.ISampleView

class SamplePresenter(private val view: ISampleView) : ISamplePresenter {

    override fun print(value: String) {
        view.print(value)
    }

    override fun showError() {
        view.showError()
    }
}