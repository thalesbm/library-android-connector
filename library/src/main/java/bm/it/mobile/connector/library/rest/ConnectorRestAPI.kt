package bm.it.mobile.connector.library.rest

import android.util.Log
import java.io.*
import java.net.HttpURLConnection
import java.net.URL

class ConnectorRestAPI: IConnectorRestAPI {
    private val TAG = ConnectorRestAPI::class.java.simpleName

    @Throws(IOException::class)
    override fun post(sBody: String, sUrl: String): ConnectorResponse {
        lateinit var connection: HttpURLConnection
        var sb: StringBuilder = StringBuilder()

        try {
            val url = URL(sUrl)
            connection = url.openConnection() as HttpURLConnection
            connection.requestMethod = "POST"
            connection.setRequestProperty("Content-Type", "application/json")
            connection.connectTimeout = 10000
            connection.doOutput = true

            val body = sBody.toByteArray()
            connection.outputStream.write(body)
            connection.outputStream.flush()
            connection.outputStream.close()

            Log.d(TAG, "##############################################")
            Log.d(TAG, "HTTP URL: $sUrl")
            Log.d(TAG, "HTTP POST")
            Log.d(TAG, "HTTP response code: " + connection.responseCode)
            Log.d(TAG, "HTTP response message: " + connection.responseMessage)
            Log.d(TAG, "##############################################")

            var line: String?
            val reader = BufferedReader(InputStreamReader(connection.inputStream))
            while (reader.readLine().also { line = it } != null) {
                sb.append(line)
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return ConnectorResponse(
            connection.responseCode,
            connection.responseMessage,
            connection.requestMethod,
            sUrl,
            sb.toString()
        )
    }

    @Throws(IOException::class)
    override fun get(sUrl: String): ConnectorResponse {
        lateinit var connection: HttpURLConnection
        var sb: StringBuilder = StringBuilder()

        try {
            val url = URL(sUrl)
            connection = url.openConnection() as HttpURLConnection
            connection.requestMethod = "GET"
            connection.setRequestProperty("Content-Type", "application/json")
            connection.connectTimeout = 10000

            Log.d(TAG, "##############################################")
            Log.d(TAG, "HTTP URL: $sUrl")
            Log.d(TAG, "HTTP GET")
            Log.d(TAG, "HTTP response code: " + connection.responseCode)
            Log.d(TAG, "HTTP response message: " + connection.responseMessage)
            Log.d(TAG, "##############################################")

            var line: String?
            val reader = BufferedReader(InputStreamReader(connection.inputStream))
            while (reader.readLine().also { line = it } != null) {
                sb.append(line)
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return ConnectorResponse(
            connection.responseCode,
            connection.responseMessage,
            connection.requestMethod,
            sUrl,
            sb.toString()
        )
    }
}