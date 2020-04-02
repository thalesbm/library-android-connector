package bm.it.mobile.connector.library.rest

interface IConnectorRestAPI {

    fun post(sBody: String, sUrl: String): ConnectorResponse

    fun get(sUrl: String): ConnectorResponse
}