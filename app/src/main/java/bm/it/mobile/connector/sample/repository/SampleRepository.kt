package bm.it.mobile.connector.sample.repository

import bm.it.mobile.connector.library.ConnectorApplication
import bm.it.mobile.connector.library.IConnectorCallback

class SampleRepository(private val connector: ConnectorApplication): ISampleRepository {

    override fun getUsers(callback: IConnectorCallback) {
        connector.configureRequest().get("", callback)
    }
}