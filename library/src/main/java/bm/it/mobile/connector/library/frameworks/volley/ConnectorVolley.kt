package bm.it.mobile.connector.library.frameworks.volley

import android.content.Context
import bm.it.mobile.connector.library.frameworks.volley.interfaces.ICallbackVolley
import bm.it.mobile.connector.library.frameworks.volley.interfaces.IConnectorVolley
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.Volley

class ConnectorVolley(private val context: Context) : IConnectorVolley {

    private lateinit var request: CustomStringRequest

    override fun post(sBody: String, sUrl: String, callback: ICallbackVolley) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun put(sBody: String, sUrl: String, callback: ICallbackVolley) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun get(sUrl: String, callback: ICallbackVolley) {
        val queue = Volley.newRequestQueue(context)
        request = CustomStringRequest(Request.Method.GET, sUrl,
            Response.Listener { response ->
                val model = HelperVolley.returnSuccessObject(
                    request.statusCode,
                    sUrl,
                    Request.Method.GET,
                    response
                )
                callback.onSuccess(model)
            },

            Response.ErrorListener {
                val model =
                    HelperVolley.returnFailureObject(request.statusCode, sUrl, Request.Method.GET)
                callback.onFailure(model)
            })
        queue.add(request)
    }

    override fun delete(sUrl: String, callback: ICallbackVolley) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}