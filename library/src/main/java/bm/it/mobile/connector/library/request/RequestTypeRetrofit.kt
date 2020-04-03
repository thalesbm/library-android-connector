package bm.it.mobile.connector.library.request

import bm.it.mobile.connector.library.IConnectorCallback

class RequestTypeRetrofit() : IRequestType {

    override fun post(url: String, body: String, callback: IConnectorCallback) {
    }

    override fun put(url: String, body: String, callback: IConnectorCallback) {
    }

    override fun delete(url: String, callback: IConnectorCallback) {
    }

    override fun get(url: String, callback: IConnectorCallback) {
    }
}