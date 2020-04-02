package bm.it.mobile.connector.sample.interactor

import bm.it.mobile.connector.library.IConnectorCallback
import bm.it.mobile.connector.sample.presenter.ISamplePresenter
import bm.it.mobile.connector.sample.repository.ISampleRepository

class SampleInteractor(private val presenter: ISamplePresenter,
                       private val repository: ISampleRepository): ISampleInteractor {

    override fun getSample() {
        repository.getUsers(object : IConnectorCallback {
            override fun onSuccess() {}
            override fun onFailure() {}
        })
    }

    override fun postSample() {

    }

    override fun putSample() {

    }

    override fun deleteSample() {

    }
}