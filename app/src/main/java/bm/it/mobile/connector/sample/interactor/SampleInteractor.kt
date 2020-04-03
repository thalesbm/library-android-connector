package bm.it.mobile.connector.sample.interactor

import bm.it.mobile.connector.library.IRepositoryCallback
import bm.it.mobile.connector.sample.model.UpdateUserModel
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

    override fun postSample(model: UpdateUserModel) {
        repository.postUser(model, object : IRepositoryCallback<UserModel>{
            override fun onSuccess(out: UserModel) {
                presenter.print(out)
            }

            override fun onFailure() {
                presenter.showError()
            }
        })
    }

    override fun putSample(model: UpdateUserModel) {
        repository.putUser(model, object : IRepositoryCallback<UserModel>{
            override fun onSuccess(out: UserModel) {
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