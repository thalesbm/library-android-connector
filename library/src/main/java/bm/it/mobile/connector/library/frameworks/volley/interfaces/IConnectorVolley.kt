package bm.it.mobile.connector.library.frameworks.volley.interfaces

interface IConnectorVolley {

    fun post(sUrl: String, sBody: String, callback: ICallbackVolley)

    fun put(sUrl: String, sBody: String, callback: ICallbackVolley)

    fun get(sUrl: String, callback: ICallbackVolley)

    fun delete(sUrl: String, callback: ICallbackVolley)
}