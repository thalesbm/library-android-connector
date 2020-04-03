package bm.it.mobile.connector.library.frameworks.volley

import bm.it.mobile.connector.library.response.ConnectorResponse

class HelperVolley {

    companion object {
        fun returnSuccessObject(
            code: Int,
            sUrl: String,
            method: Int,
            json: String
        ): ConnectorResponse {
            val response = ConnectorResponse(
                code = code,
                method = method.toString(),
                url = sUrl,
                json = json
            )
            response.print()
            return response
        }

        fun returnFailureObject(
            code: Int,
            sUrl: String,
            method: Int
        ): ConnectorResponse {
            val response = ConnectorResponse(
                code = code,
                method = method.toString(),
                url = sUrl
            )
            response.print()
            return response
        }
    }
}