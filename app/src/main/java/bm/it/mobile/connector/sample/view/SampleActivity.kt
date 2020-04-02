package bm.it.mobile.connector.sample.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import bm.it.mobile.connector.sample.R
import bm.it.mobile.connector.sample.SampleApplication
import bm.it.mobile.connector.sample.interactor.SampleInteractor
import bm.it.mobile.connector.sample.presenter.SamplePresenter
import bm.it.mobile.connector.sample.repository.SampleRepository

class SampleActivity : AppCompatActivity(), ISampleView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sample)

        val interactor = SampleInteractor(
            SamplePresenter(this),
            SampleRepository(SampleApplication.getInstance().connector))
        interactor.getUsers()
    }
}
