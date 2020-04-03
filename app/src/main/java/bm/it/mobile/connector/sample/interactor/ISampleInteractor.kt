package bm.it.mobile.connector.sample.interactor

import bm.it.mobile.connector.sample.model.UserModel

interface ISampleInteractor {

    fun getSample()

    fun postSample(model: UserModel)

    fun putSample(model: UserModel)

    fun deleteSample()
}