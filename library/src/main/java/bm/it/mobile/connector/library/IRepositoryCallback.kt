package bm.it.mobile.connector.library

interface IRepositoryCallback<T> {
    fun onSuccess(out: T)

    fun onFailure()
}