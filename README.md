# android-connector-library

```
val connector: ConnectorApplication = ConnectorApplication.Builder()
    .setContext(this)
    .setType(ConnectorType.REST_API)
    .build()
            
connector.configureRequest().get("URL", object : IConnectorCallback {
    override fun onSuccess(successResponse: ConnectorSuccessResponse) {
    }

    override fun onFailure(failureResponse: ConnectorFailureResponse) {
    }
})
```
