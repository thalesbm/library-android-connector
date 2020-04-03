package bm.it.mobile.connector.library.frameworks.volley

import android.content.Context
import android.util.Log
import bm.it.mobile.connector.library.IConnectorCallback
import bm.it.mobile.connector.library.frameworks.retrofit.ConnectorRetrofit
import bm.it.mobile.connector.library.interfaces.IConnector
import bm.it.mobile.connector.library.interfaces.IRequestType
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley

class RequestTypeVolley(private val baseURL: String, private val context: Context) :
    IRequestType {

    private var rest: IConnector = ConnectorVolley(context)

    override fun post(url: String, body: String, callback: IConnectorCallback) {
    }

    override fun put(url: String, body: String, callback: IConnectorCallback) {
    }

    override fun delete(url: String, callback: IConnectorCallback) {
    }

    override fun get(url: String, callback: IConnectorCallback) {
        rest.get(baseURL + url)
    }
}