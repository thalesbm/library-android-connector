package bm.it.mobile.connector.library.frameworks.volley

import com.android.volley.NetworkResponse
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest

class CustomStringRequest(
    method: Int,
    url: String?,
    listener: Response.Listener<String>?,
    errorListener: Response.ErrorListener?
) : StringRequest(method, url, listener, errorListener) {

    var statusCode = 500

    override fun parseNetworkResponse(response: NetworkResponse?): Response<String> {
        statusCode = response?.statusCode!!
        return super.parseNetworkResponse(response)
    }
}