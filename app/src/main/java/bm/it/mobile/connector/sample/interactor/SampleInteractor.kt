package bm.it.mobile.connector.sample.interactor

import bm.it.mobile.connector.library.IRepositoryCallback
import bm.it.mobile.connector.sample.model.UriModel
import bm.it.mobile.connector.sample.model.UserModel
import bm.it.mobile.connector.sample.presenter.ISamplePresenter
import bm.it.mobile.connector.sample.repository.ISampleRepository

class SampleInteractor(private val presenter: ISamplePresenter,
                       private val repository: ISampleRepository): ISampleInteractor {

    override fun getSample() {
        repository.getUsers(object : IRepositoryCallback<UserModel>{
            override fun onSuccess(out: UserModel) {
                presenter.print(out)
            }

            override fun onFailure() {
                presenter.showError()
            }
        })
    }

    override fun postSample(model: UserModel) {
        repository.postUser(model, object : IRepositoryCallback<UriModel>{
            override fun onSuccess(out: UriModel) {
                presenter.print(out)
            }

            override fun onFailure() {
                presenter.showError()
            }
        })
    }

    override fun putSample(model: UserModel) {
        repository.putUser(model, object : IRepositoryCallback<UriModel>{
            override fun onSuccess(out: UriModel) {
                presenter.print(out)
            }

            override fun onFailure() {
                presenter.showError()
            }
        })
    }

    override fun deleteSample() {

    }
}