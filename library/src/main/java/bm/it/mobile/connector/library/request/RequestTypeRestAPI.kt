package bm.it.mobile.connector.library.request

import bm.it.mobile.connector.library.IConnectorCallback
import bm.it.mobile.connector.library.enums.HTTPCodes
import bm.it.mobile.connector.library.rest.ConnectorResponse
import bm.it.mobile.connector.library.rest.ConnectorRestAPI

class RequestTypeRestAPI : IRequestType {

    private var rest: ConnectorRestAPI = ConnectorRestAPI()

    override fun post(url: String, body: String, callback: IConnectorCallback) {
        val response = rest.post(body, url)
        analyseResponse(response, callback)
    }

    override fun put(url: String, body: String, callback: IConnectorCallback) {
    }

    override fun delete(url: String, body: String, callback: IConnectorCallback) {
    }

    override fun get(url: String, callback: IConnectorCallback) {
        val response = rest.get(url)
        analyseResponse(response, callback)
    }

    private fun analyseResponse(response: ConnectorResponse, callback: IConnectorCallback) {
        if (response.code == HTTPCodes.SUCCESS.code) {
            callback.onSuccess()
        }
        callback.onFailure()
    }
}