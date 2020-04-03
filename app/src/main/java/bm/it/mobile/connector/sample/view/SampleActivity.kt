package bm.it.mobile.connector.sample.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import bm.it.mobile.connector.sample.R
import bm.it.mobile.connector.sample.SampleApplication
import bm.it.mobile.connector.sample.interactor.ISampleInteractor
import bm.it.mobile.connector.sample.interactor.SampleInteractor
import bm.it.mobile.connector.sample.model.UserModel
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
            val model = UserModel(27, "thales.bm92@gmail.com", "Thales Bertolini Marega", true)
            interactor.putSample(model)
        }

        activitySampleDeleteButton.setOnClickListener {
            interactor.deleteSample()
        }

        activitySamplePostButton.setOnClickListener {
            val model = UserModel(27, "thales.bm92@gmail.com", "Thales B Marega", true)
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
