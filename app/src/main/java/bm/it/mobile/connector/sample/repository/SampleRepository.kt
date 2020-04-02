package bm.it.mobile.connector.sample.repository

import bm.it.mobile.connector.library.ConnectorApplication
import bm.it.mobile.connector.library.IConnectorCallback
import bm.it.mobile.connector.sample.SampleURL

class SampleRepository(private val connector: ConnectorApplication): ISampleRepository {

    override fun getUsers(callback: IConnectorCallback) {
        connector.configureRequest().get(SampleURL.GET, callback)
    }
}