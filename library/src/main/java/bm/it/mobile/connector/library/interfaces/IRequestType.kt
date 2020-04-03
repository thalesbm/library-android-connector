package bm.it.mobile.connector.library.interfaces

import bm.it.mobile.connector.library.IConnectorCallback
import bm.it.mobile.connector.library.enums.HTTPCodes
import bm.it.mobile.connector.library.response.ConnectorFailureResponse
import bm.it.mobile.connector.library.response.ConnectorResponse
import bm.it.mobile.connector.library.response.ConnectorSuccessResponse

abstract class IRequestType {

    abstract fun post(url: String, body: String, callback: IConnectorCallback)

    abstract fun put(url: String, body: String, callback: IConnectorCallback)

    abstract  fun delete(url: String, callback: IConnectorCallback)

    abstract fun get(url: String, callback: IConnectorCallback)

    protected fun analyseResponse(
        successResponse: ConnectorResponse,
        callback: IConnectorCallback
    ) {
        if (successResponse.code == HTTPCodes.SUCCESS.code ||
            successResponse.code == HTTPCodes.CREATED.code ||
            successResponse.code == HTTPCodes.NO_CONTENT.code
        ) {
            callback.onSuccess(
                ConnectorSuccessResponse(
                    code = successResponse.code,
                    json = successResponse.json,
                    url = successResponse.url
                )
            )
        } else {
            callback.onFailure(
                ConnectorFailureResponse(
                    code = successResponse.code,
                    message = successResponse.message,
                    url = successResponse.url
                )
            )
        }
    }
}