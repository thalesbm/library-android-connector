# android-connector-library

### A library for Android that you can choose which rest framework you would like to use!

##### Status
- [x] Sample App
- [x] HttpURLConnection
- [ ] Retrofit
- [x] Volley

------

##### How to use?

```kotlin
val connector: ConnectorApplication = ConnectorApplication.Builder()
    .setContext(this)
    .setType(ConnectorType.REST_API)
    .setBaseURL("URL")
    .build()
            
connector.configureRequest().get("URL", object : IConnectorCallback {
    override fun onSuccess(successResponse: ConnectorSuccessResponse) {
    }

    override fun onFailure(failureResponse: ConnectorFailureResponse) {
    }
})
```
