package bm.it.mobile.connector.sample

import android.app.Application
import bm.it.mobile.connector.library.ConnectorApplication
import bm.it.mobile.connector.library.ConnectorType

class SampleApplication: Application() {

    lateinit var connector: ConnectorApplication

    override fun onCreate() {
        super.onCreate()

        connector = ConnectorApplication.Builder()
            .setContext(this)
            .setType(ConnectorType.RETROFIT)
            .build()
    }

    companion object {
        private lateinit var instance: SampleApplication

        fun getInstance(): SampleApplication {
            if (instance == null) {
                instance = SampleApplication()
            }
            return instance
        }
    }
}