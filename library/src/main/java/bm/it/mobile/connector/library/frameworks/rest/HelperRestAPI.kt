package bm.it.mobile.connector.library.frameworks.rest

import bm.it.mobile.connector.library.response.ConnectorSuccessResponse
import java.net.HttpURLConnection

class HelperRestAPI {

    companion object {
        fun returnObject(
            connection: HttpURLConnection,
            sUrl: String,
            sb: StringBuilder
        ): ConnectorSuccessResponse {
            val response = ConnectorSuccessResponse(
                code = connection.responseCode,
                message = connection.responseMessage,
                method = connection.requestMethod,
                url = sUrl,
                json = sb.toString()
            )
            response.print()
            return response
        }
    }
}