package bm.it.mobile.connector.sample.repository

import bm.it.mobile.connector.sample.presenter.ISamplePresenter
import bm.it.mobile.connector.sample.repository.ISampleRepository
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class SampleRepositoryTest {

    @Mock
    private lateinit var presenter: ISamplePresenter

    @Mock
    private lateinit var repository: ISampleRepository

    private lateinit var interactor: ISampleInteractor

    @Before
    fun setUp() {
        interactor = SampleInteractor(presenter, repository)
    }

    @Test
    fun getSampleTest() {

    }
}
