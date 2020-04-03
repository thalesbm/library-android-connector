package bm.it.mobile.connector.sample

enum class SampleURL(val url: String) {
    BASE("https://reqres.in"),
    GET("/api/users/3"),
    POST("/api/users"),
    PUT("/api/users/2"),
    DELETE("/api/users/4")
}