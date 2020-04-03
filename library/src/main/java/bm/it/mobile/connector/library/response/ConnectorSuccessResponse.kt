package bm.it.mobile.connector.library.response

import android.util.Log

class ConnectorSuccessResponse(
    val code: Int,
    val url: String,
    val json: String
) {
    fun print() {
        val log = "ConnectorSuccessResponse(code=$code, url='$url', json='$json')"
        Log.d("LOG", log)
    }
}