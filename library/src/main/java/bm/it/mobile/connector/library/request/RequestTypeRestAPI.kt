package bm.it.mobile.connector.library.request

import bm.it.mobile.connector.library.IConnectorCallback
import bm.it.mobile.connector.library.enums.HTTPCodes
import bm.it.mobile.connector.library.response.ConnectorFailureResponse
import bm.it.mobile.connector.library.response.ConnectorSuccessResponse
import bm.it.mobile.connector.library.rest.ConnectorRestAPI
import org.jetbrains.anko.doAsync

class RequestTypeRestAPI : IRequestType {

    private var rest: ConnectorRestAPI = ConnectorRestAPI()

    override fun post(url: String, body: String, callback: IConnectorCallback) {
        doAsync {
            val response = rest.post(body, url)
            analyseResponse(response, callback)
        }
    }

    override fun put(url: String, body: String, callback: IConnectorCallback) {
        doAsync {
            val response = rest.put(body, url)
            analyseResponse(response, callback)
        }
    }

    override fun get(url: String, callback: IConnectorCallback) {
        doAsync {
            val response = rest.get(url)
            analyseResponse(response, callback)
        }
    }

    override fun delete(url: String, callback: IConnectorCallback) {
        doAsync {
            val response = rest.delete(url)
            analyseResponse(response, callback)
        }
    }

    private fun analyseResponse(
        successResponse: ConnectorSuccessResponse,
        callback: IConnectorCallback
    ) {
        if (successResponse.code == HTTPCodes.SUCCESS.code ||
            successResponse.code == HTTPCodes.CREATED.code ||
            successResponse.code == HTTPCodes.NO_CONTENT.code
        ) {
            callback.onSuccess(successResponse)
        } else {
            callback.onFailure(
                ConnectorFailureResponse(
                    successResponse.code, successResponse.message,
                    successResponse.method, successResponse.url
                )
            )
        }
    }
}