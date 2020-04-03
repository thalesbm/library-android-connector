package bm.it.mobile.connector.library

interface IRepositoryCallback<T  : Any> {
    fun onSuccess(out: T)

    fun onFailure()
}