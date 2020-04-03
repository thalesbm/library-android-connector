package bm.it.mobile.connector.library.response

import android.util.Log

class ConnectorResponse(
    val code: Int = 0,
    val message: String = "",
    val method: String = "",
    val url: String = "",
    val json: String = ""
) {
    fun print() {
        val log = "ConnectorSuccessResponse(code=$code, message='$message', method='$method', url='$url', json='$json')"
        Log.d("LOG", log)
    }
}