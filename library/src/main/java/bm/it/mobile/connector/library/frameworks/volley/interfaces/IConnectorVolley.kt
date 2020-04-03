package bm.it.mobile.connector.library.frameworks.volley.interfaces

interface IConnectorVolley {

    fun post(sBody: String, sUrl: String, callback: ICallbackVolley)

    fun put(sBody: String, sUrl: String, callback: ICallbackVolley)

    fun get(sUrl: String, callback: ICallbackVolley)

    fun delete(sUrl: String, callback: ICallbackVolley)
}