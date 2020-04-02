package bm.it.mobile.connector.library.request

import bm.it.mobile.connector.library.IConnectorCallback

interface IRequestType {

    fun post(url: String, callback: IConnectorCallback)

    fun put(url: String, callback: IConnectorCallback)

    fun delete(url: String, callback: IConnectorCallback)

    fun get(url: String, callback: IConnectorCallback)
}