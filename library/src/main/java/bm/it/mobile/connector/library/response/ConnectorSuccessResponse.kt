package bm.it.mobile.connector.library.response

class ConnectorSuccessResponse(
    val code: Int,
    val message: String,
    val method: String,
    val url: String,
    val json: String
)