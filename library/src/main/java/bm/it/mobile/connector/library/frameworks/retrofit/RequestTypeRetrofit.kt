package bm.it.mobile.connector.library.frameworks.retrofit

import bm.it.mobile.connector.library.IConnectorCallback
import bm.it.mobile.connector.library.interfaces.IConnector
import bm.it.mobile.connector.library.interfaces.IRequestType

class RequestTypeRetrofit(private val baseURL: String) :
    IRequestType() {

    private var rest: IConnector = ConnectorRetrofit()

    override fun post(url: String, body: String, callback: IConnectorCallback) {
        rest.post(baseURL + url, body)
    }

    override fun put(url: String, body: String, callback: IConnectorCallback) {
        rest.put(baseURL + url, body)
    }

    override fun delete(url: String, callback: IConnectorCallback) {
        rest.delete(baseURL + url)
    }

    override fun get(url: String, callback: IConnectorCallback) {
        rest.get(baseURL + url)
    }
}