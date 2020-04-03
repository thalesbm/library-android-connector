package bm.it.mobile.connector.library.frameworks.volley

import android.content.Context
import android.util.Log
import bm.it.mobile.connector.library.interfaces.IConnector
import bm.it.mobile.connector.library.response.ConnectorSuccessResponse
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley

class ConnectorVolley(private val context: Context) : IConnector {

    override fun post(sBody: String, sUrl: String): ConnectorSuccessResponse {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun put(sBody: String, sUrl: String): ConnectorSuccessResponse {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun get(sUrl: String): ConnectorSuccessResponse {
        val queue = Volley.newRequestQueue(context)

        lateinit var json: String

        val stringRequest = StringRequest(Request.Method.GET, sUrl,
            Response.Listener<String> { response ->
                json = response
            },
            Response.ErrorListener { Log.d("THALES1", "ERROR") })

        queue.add(stringRequest)

        return ConnectorSuccessResponse(0, "", Request.Method.GET.toString(), sUrl, json)
    }

    override fun delete(sUrl: String): ConnectorSuccessResponse {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}