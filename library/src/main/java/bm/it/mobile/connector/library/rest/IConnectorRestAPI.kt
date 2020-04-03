package bm.it.mobile.connector.library.rest

import bm.it.mobile.connector.library.response.ConnectorSuccessResponse

interface IConnectorRestAPI {

    fun post(sBody: String, sUrl: String): ConnectorSuccessResponse

    fun put(sBody: String, sUrl: String): ConnectorSuccessResponse

    fun get(sUrl: String): ConnectorSuccessResponse

    fun delete(sUrl: String): ConnectorSuccessResponse
}