package bm.it.mobile.connector.library

import android.content.Context
import bm.it.mobile.connector.library.request.IRequestType
import bm.it.mobile.connector.library.request.RequestType

class ConnectorApplication(private val context: Context,
                           private val connectorType: ConnectorType) {

    private lateinit var requestType: RequestType

    fun configureRequest(): IRequestType {
        if (requestType == null) {
            requestType =
                RequestType(connectorType)
        }
        return requestType
    }

    class Builder {
        private lateinit var context: Context
        private lateinit var connectorType: ConnectorType

        fun setContext(context: Context): Builder {
            this.context = context
            return this
        }

        fun setType(connectorType: ConnectorType): Builder {
            this.connectorType = connectorType
            return this
        }

        fun build(): ConnectorApplication {
            return ConnectorApplication(context, connectorType)
        }
    }
}