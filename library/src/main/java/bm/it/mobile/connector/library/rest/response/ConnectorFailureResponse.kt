package bm.it.mobile.connector.library.rest.response

class ConnectorFailureResponse(
    val code: Int,
    val message: String,
    val method: String,
    val url: String
)