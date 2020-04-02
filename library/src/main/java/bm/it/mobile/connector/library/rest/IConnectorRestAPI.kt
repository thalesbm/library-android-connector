package bm.it.mobile.connector.library.rest

import bm.it.mobile.connector.library.rest.response.ConnectorSuccessResponse

interface IConnectorRestAPI {

    fun post(sBody: String, sUrl: String): ConnectorSuccessResponse

    fun get(sUrl: String): ConnectorSuccessResponse
}