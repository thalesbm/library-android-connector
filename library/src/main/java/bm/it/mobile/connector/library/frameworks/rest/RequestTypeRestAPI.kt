package bm.it.mobile.connector.library.frameworks.rest

import bm.it.mobile.connector.library.IConnectorCallback
import bm.it.mobile.connector.library.enums.HTTPCodes
import bm.it.mobile.connector.library.interfaces.IConnector
import bm.it.mobile.connector.library.interfaces.IRequestType
import bm.it.mobile.connector.library.response.ConnectorFailureResponse
import bm.it.mobile.connector.library.response.ConnectorResponse
import bm.it.mobile.connector.library.response.ConnectorSuccessResponse
import org.jetbrains.anko.doAsync

class RequestTypeRestAPI(private val baseURL: String) :
    IRequestType() {

    private var rest: IConnector = ConnectorRestAPI()

    override fun post(url: String, body: String, callback: IConnectorCallback) {
        doAsync {
            val response = rest.post(body, baseURL + url)
            analyseResponse(response, callback)
        }
    }

    override fun put(url: String, body: String, callback: IConnectorCallback) {
        doAsync {
            val response = rest.put(body, baseURL + url)
            analyseResponse(response, callback)
        }
    }

    override fun get(url: String, callback: IConnectorCallback) {
        doAsync {
            val response = rest.get(baseURL + url)
            analyseResponse(response, callback)
        }
    }

    override fun delete(url: String, callback: IConnectorCallback) {
        doAsync {
            val response = rest.delete(baseURL + url)
            analyseResponse(response, callback)
        }
    }
}