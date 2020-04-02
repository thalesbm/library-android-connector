package bm.it.mobile.connector.sample.repository

import bm.it.mobile.connector.library.IConnectorCallback

interface ISampleRepository {

    fun getUsers(callback: IConnectorCallback)
}