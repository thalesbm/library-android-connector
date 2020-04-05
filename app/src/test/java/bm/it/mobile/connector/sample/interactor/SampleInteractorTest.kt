package bm.it.mobile.connector.sample.interactor

import bm.it.mobile.connector.sample.view.ISampleView
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class SampleInteractorTest {

    @Mock
    private lateinit var view: ISampleView

    private lateinit var presenter: ISamplePresenter

    @Before
    fun setUp() {
        presenter = SamplePresenter(view)
    }

    @Test
    fun printTest() {
        presenter.print("oi")
        verify(view).print("oi")
    }

    @Test
    fun showErrorTest() {
        presenter.showError()
        verify(view).showError()
    }
}
