package bm.it.mobile.connector.sample.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import bm.it.mobile.connector.sample.R
import bm.it.mobile.connector.sample.SampleApplication
import bm.it.mobile.connector.sample.interactor.ISampleInteractor
import bm.it.mobile.connector.sample.interactor.SampleInteractor
import bm.it.mobile.connector.sample.model.UpdateUserModel
import bm.it.mobile.connector.sample.presenter.SamplePresenter
import bm.it.mobile.connector.sample.repository.SampleRepository
import kotlinx.android.synthetic.main.activity_sample.*

class SampleActivity : AppCompatActivity(), ISampleView {

    private lateinit var interactor: ISampleInteractor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sample)

        interactor = SampleInteractor(
            SamplePresenter(this),
            SampleRepository(SampleApplication.instance.connector))

        init()
    }

    private fun init() {
        activitySampleGetButton.setOnClickListener {
            interactor.getSample()
        }

        activitySamplePutButton.setOnClickListener {
            val model =
                UpdateUserModel(
                    firstName = "Thales",
                    job = "Developer"
                )
            interactor.putSample(model)
        }

        activitySampleDeleteButton.setOnClickListener {
            interactor.deleteSample()
        }

        activitySamplePostButton.setOnClickListener {
            val model =
                UpdateUserModel(
                    firstName = "Thales Marega",
                    job = "Developer"
                )
            interactor.postSample(model)
        }
    }

    override fun print(value: String) {
        activitySampleLabelTextView.apply {
            text = value
        }
    }

    override fun showError() {

    }
}
