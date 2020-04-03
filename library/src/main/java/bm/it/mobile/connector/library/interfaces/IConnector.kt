package bm.it.mobile.connector.library.interfaces

import bm.it.mobile.connector.library.response.ConnectorSuccessResponse

interface IConnector {

    fun post(sBody: String, sUrl: String): ConnectorSuccessResponse

    fun put(sBody: String, sUrl: String): ConnectorSuccessResponse

    fun get(sUrl: String): ConnectorSuccessResponse

    fun delete(sUrl: String): ConnectorSuccessResponse
}