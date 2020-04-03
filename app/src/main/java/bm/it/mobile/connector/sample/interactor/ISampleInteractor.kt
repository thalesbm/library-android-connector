package bm.it.mobile.connector.sample.interactor

import bm.it.mobile.connector.sample.model.UpdateUserModel

interface ISampleInteractor {

    fun getSample()

    fun deleteSample()

    fun postSample(model: UpdateUserModel)

    fun putSample(model: UpdateUserModel)
}