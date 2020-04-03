package bm.it.mobile.connector.library

import android.content.Context
import bm.it.mobile.connector.library.enums.ConnectorType
import bm.it.mobile.connector.library.request.IRequestType
import bm.it.mobile.connector.library.request.RequestTypeRestAPI
import bm.it.mobile.connector.library.request.RequestTypeRetrofit
import bm.it.mobile.connector.library.request.RequestTypeVolley

class ConnectorApplication(private val context: Context,
                           private val connectorType: ConnectorType,
                           private val baseURL: String) {

    private lateinit var requestType: IRequestType

    fun configureRequest(): IRequestType {
        if (!::requestType.isInitialized) {

            requestType = when (connectorType) {
                ConnectorType.REST_API -> {
                    RequestTypeRestAPI(baseURL)
                }
                ConnectorType.RETROFIT -> {
                    RequestTypeRetrofit(baseURL)
                }
                ConnectorType.VOLLEY -> {
                    RequestTypeVolley(baseURL, context)
                }
            }
        }
        return requestType
    }

    class Builder {
        private lateinit var context: Context
        private lateinit var connectorType: ConnectorType
        private lateinit var baseURL: String

        fun setContext(context: Context): Builder {
            this.context = context
            return this
        }

        fun setType(connectorType: ConnectorType): Builder {
            this.connectorType = connectorType
            return this
        }

        fun setBaseURL(baseURL: String): Builder {
            this.baseURL = baseURL
            return this
        }

        fun build(): ConnectorApplication {
            return ConnectorApplication(context, connectorType, baseURL)
        }
    }
}