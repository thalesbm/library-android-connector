package bm.it.mobile.connector.sample.presenter

import bm.it.mobile.connector.sample.view.ISampleView

class SamplePresenter(private val view: ISampleView): ISamplePresenter {

    override fun print(json: String) {
        view.print(json)
    }
}