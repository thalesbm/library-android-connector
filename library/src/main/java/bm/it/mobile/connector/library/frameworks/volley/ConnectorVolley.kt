package bm.it.mobile.connector.library.frameworks.volley

import android.content.Context
import bm.it.mobile.connector.library.frameworks.volley.interfaces.ICallbackVolley
import bm.it.mobile.connector.library.frameworks.volley.interfaces.IConnectorVolley
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.Volley

class ConnectorVolley(private val context: Context) : IConnectorVolley {

    private lateinit var request: CustomStringRequest

    override fun post(sUrl: String, sBody: String, callback: ICallbackVolley) {
        postOrPut(sUrl, sBody, callback, Request.Method.POST)
    }

    override fun put(sUrl: String, sBody: String, callback: ICallbackVolley) {
        postOrPut(sUrl, sBody, callback, Request.Method.PUT)
    }

    override fun get(sUrl: String, callback: ICallbackVolley) {
        getOrDelete(sUrl, callback, Request.Method.GET)
    }

    override fun delete(sUrl: String, callback: ICallbackVolley) {
        getOrDelete(sUrl, callback, Request.Method.DELETE)
    }

    private fun postOrPut(
        sUrl: String,
        sBody: String,
        callback: ICallbackVolley,
        method: Int
    ) {
        val queue = Volley.newRequestQueue(context)
        request = CustomStringRequest(method, sUrl,
            Response.Listener { response ->
                val model = HelperVolley.returnSuccessObject(
                    request.statusCode,
                    sUrl,
                    method,
                    response
                )
                callback.onSuccess(model)
            },

            Response.ErrorListener {
                val model =
                    HelperVolley.returnFailureObject(request.statusCode, sUrl, method)
                callback.onFailure(model)
            })
        request.setBody(sBody)
        queue.add(request)
    }

    private fun getOrDelete(
        sUrl: String,
        callback: ICallbackVolley,
        method: Int
    ) {
        val queue = Volley.newRequestQueue(context)
        request = CustomStringRequest(method, sUrl,
            Response.Listener { response ->
                val model = HelperVolley.returnSuccessObject(
                    request.statusCode,
                    sUrl,
                    method,
                    response
                )
                callback.onSuccess(model)
            },

            Response.ErrorListener {
                val model =
                    HelperVolley.returnFailureObject(request.statusCode, sUrl, method)
                callback.onFailure(model)
            })
        queue.add(request)
    }
}