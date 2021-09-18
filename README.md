# library-android-connector

### An android library that you can choose which rest framework you would like to use!

------

#### Status
- [x] Sample App
- [x] HttpURLConnection
- [ ] Retrofit
- [x] Volley

------

#### How to use?

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


------

#### Installation

###### Step 1. Add the JitPack repository to your build file
```
allprojects {
    repositories {
        maven { url 'https://jitpack.io' }
    }
}
```

###### Step 2. Add the dependency
```
dependencies {
    implementation 'com.github.thalesbm:library-android-connector:1.0.0'
}
```
