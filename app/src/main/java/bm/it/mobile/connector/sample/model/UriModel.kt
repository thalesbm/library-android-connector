package bm.it.mobile.connector.sample.model

class UriModel(
    val age: Int,
    val email: String,
    val name: String,
    val isDeveloper: Boolean
) {
    fun printModel(): String {
        return "$name, $age years old"
    }
}