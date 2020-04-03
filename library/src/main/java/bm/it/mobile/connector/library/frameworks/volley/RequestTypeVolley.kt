package bm.it.mobile.connector.library.frameworks.volley

import android.content.Context
import bm.it.mobile.connector.library.IConnectorCallback
import bm.it.mobile.connector.library.frameworks.volley.interfaces.ICallbackVolley
import bm.it.mobile.connector.library.frameworks.volley.interfaces.IConnectorVolley
import bm.it.mobile.connector.library.interfaces.IRequestType
import bm.it.mobile.connector.library.response.ConnectorResponse

class RequestTypeVolley(private val baseURL: String, private val context: Context) :
    IRequestType() {

    private var rest: IConnectorVolley = ConnectorVolley(context)

    override fun post(url: String, body: String, callback: IConnectorCallback) {
        rest.post(baseURL + url, body, object : ICallbackVolley{
            override fun onSuccess(connector: ConnectorResponse) {
                analyseResponse(connector, callback)
            }

            override fun onFailure(connector: ConnectorResponse) {
                analyseResponse(connector, callback)
            }
        })
    }

    override fun put(url: String, body: String, callback: IConnectorCallback) {
        rest.put(baseURL + url, body, object : ICallbackVolley{
            override fun onSuccess(connector: ConnectorResponse) {
                analyseResponse(connector, callback)
            }

            override fun onFailure(connector: ConnectorResponse) {
                analyseResponse(connector, callback)
            }
        })
    }

    override fun delete(url: String, callback: IConnectorCallback) {
        rest.delete(baseURL + url, object : ICallbackVolley{
            override fun onSuccess(connector: ConnectorResponse) {
                analyseResponse(connector, callback)
            }

            override fun onFailure(connector: ConnectorResponse) {
                analyseResponse(connector, callback)
            }
        })
    }

    override fun get(url: String, callback: IConnectorCallback) {
        rest.get(baseURL + url, object : ICallbackVolley{
            override fun onSuccess(connector: ConnectorResponse) {
                analyseResponse(connector, callback)
            }

            override fun onFailure(connector: ConnectorResponse) {
                analyseResponse(connector, callback)
            }
        })
    }
}