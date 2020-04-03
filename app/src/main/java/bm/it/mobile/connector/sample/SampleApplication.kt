package bm.it.mobile.connector.sample

import android.app.Application
import bm.it.mobile.connector.library.ConnectorApplication
import bm.it.mobile.connector.library.enums.ConnectorType

class SampleApplication: Application() {

    lateinit var connector: ConnectorApplication

    override fun onCreate() {
        super.onCreate()

        instance = this

        connector = ConnectorApplication.Builder()
            .setContext(this)
            .setBaseURL(SampleURL.BASE.url)
            .setType(ConnectorType.VOLLEY)
            .build()
    }

    companion object {
        lateinit var instance: SampleApplication
    }
}