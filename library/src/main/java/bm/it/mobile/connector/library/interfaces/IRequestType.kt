package bm.it.mobile.connector.library.interfaces

import bm.it.mobile.connector.library.IConnectorCallback

interface IRequestType {

    fun post(url: String, body: String, callback: IConnectorCallback)

    fun put(url: String, body: String, callback: IConnectorCallback)

    fun delete(url: String, callback: IConnectorCallback)

    fun get(url: String, callback: IConnectorCallback)
}