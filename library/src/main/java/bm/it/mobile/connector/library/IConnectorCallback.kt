package bm.it.mobile.connector.library

import bm.it.mobile.connector.library.rest.response.ConnectorFailureResponse
import bm.it.mobile.connector.library.rest.response.ConnectorSuccessResponse

interface IConnectorCallback {
    fun onSuccess(successResponse: ConnectorSuccessResponse)

    fun onFailure(failureResponse: ConnectorFailureResponse)
}