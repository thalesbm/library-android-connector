package bm.it.mobile.connector.library.request

import android.content.Context
import android.util.Log
import bm.it.mobile.connector.library.IConnectorCallback
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley

class RequestTypeVolley(private val baseURL: String, private val context: Context) : IRequestType {

    override fun post(url: String, body: String, callback: IConnectorCallback) {
    }

    override fun put(url: String, body: String, callback: IConnectorCallback) {
    }

    override fun delete(url: String, callback: IConnectorCallback) {
    }

    override fun get(url: String, callback: IConnectorCallback) {
        val queue = Volley.newRequestQueue(context)

        val stringRequest = StringRequest(Request.Method.GET, baseURL + url,
            Response.Listener<String> { response ->
                Log.d("THALES", response)
            },
            Response.ErrorListener { Log.d("THALES1", "ERROR") })

        queue.add(stringRequest)
    }
}