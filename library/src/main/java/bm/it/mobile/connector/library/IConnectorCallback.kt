package bm.it.mobile.connector.library

import bm.it.mobile.connector.library.response.ConnectorFailureResponse
import bm.it.mobile.connector.library.response.ConnectorSuccessResponse

interface IConnectorCallback {
    fun onSuccess(successResponse: ConnectorSuccessResponse)

    fun onFailure(failureResponse: ConnectorFailureResponse)
}