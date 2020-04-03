package bm.it.mobile.connector.library.frameworks.volley.interfaces

import bm.it.mobile.connector.library.response.ConnectorResponse

interface ICallbackVolley {

    fun onSuccess(connector: ConnectorResponse)

    fun onFailure(connector: ConnectorResponse)
}