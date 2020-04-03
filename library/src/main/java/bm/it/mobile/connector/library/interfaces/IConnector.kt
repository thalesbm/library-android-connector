package bm.it.mobile.connector.library.interfaces

import bm.it.mobile.connector.library.response.ConnectorResponse

interface IConnector {

    fun post(sBody: String, sUrl: String): ConnectorResponse

    fun put(sBody: String, sUrl: String): ConnectorResponse

    fun get(sUrl: String): ConnectorResponse

    fun delete(sUrl: String): ConnectorResponse
}