package bm.it.mobile.connector.library.frameworks.rest

import bm.it.mobile.connector.library.interfaces.IConnector
import bm.it.mobile.connector.library.response.ConnectorSuccessResponse
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

class ConnectorRestAPI : IConnector {

    @Throws(IOException::class)
    override fun post(sBody: String, sUrl: String): ConnectorSuccessResponse {
        lateinit var connection: HttpURLConnection
        val sb: StringBuilder = StringBuilder()

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

            var line: String?
            val reader = BufferedReader(InputStreamReader(connection.inputStream))
            while (reader.readLine().also { line = it } != null) {
                sb.append(line)
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return HelperRestAPI.returnObject(connection, sUrl, sb)
    }

    @Throws(IOException::class)
    override fun put(sBody: String, sUrl: String): ConnectorSuccessResponse {
        lateinit var connection: HttpURLConnection
        val sb: StringBuilder = StringBuilder()

        try {
            val url = URL(sUrl)
            connection = url.openConnection() as HttpURLConnection
            connection.requestMethod = "PUT"
            connection.setRequestProperty("Content-Type", "application/json")
            connection.connectTimeout = 10000
            connection.doOutput = true

            val body = sBody.toByteArray()
            connection.outputStream.write(body)
            connection.outputStream.flush()
            connection.outputStream.close()

            var line: String?
            val reader = BufferedReader(InputStreamReader(connection.inputStream))
            while (reader.readLine().also { line = it } != null) {
                sb.append(line)
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return HelperRestAPI.returnObject(connection, sUrl, sb)
    }

    @Throws(IOException::class)
    override fun get(sUrl: String): ConnectorSuccessResponse {
        lateinit var connection: HttpURLConnection
        val sb: StringBuilder = StringBuilder()

        try {
            val url = URL(sUrl)
            connection = url.openConnection() as HttpURLConnection
            connection.requestMethod = "GET"
            connection.setRequestProperty("Content-Type", "application/json")
            connection.connectTimeout = 10000

            var line: String?
            val reader = BufferedReader(InputStreamReader(connection.inputStream))
            while (reader.readLine().also { line = it } != null) {
                sb.append(line)
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return HelperRestAPI.returnObject(connection, sUrl, sb)
    }

    @Throws(IOException::class)
    override fun delete(sUrl: String): ConnectorSuccessResponse {
        lateinit var connection: HttpURLConnection
        val sb: StringBuilder = StringBuilder()

        try {
            val url = URL(sUrl)
            connection = url.openConnection() as HttpURLConnection
            connection.requestMethod = "DELETE"
            connection.setRequestProperty("Content-Type", "application/json")
            connection.connectTimeout = 10000

            var line: String?
            val reader = BufferedReader(InputStreamReader(connection.inputStream))
            while (reader.readLine().also { line = it } != null) {
                sb.append(line)
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return HelperRestAPI.returnObject(connection, sUrl, sb)
    }
}