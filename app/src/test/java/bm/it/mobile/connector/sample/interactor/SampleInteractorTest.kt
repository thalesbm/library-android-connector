package bm.it.mobile.connector.sample.interactor

import bm.it.mobile.connector.library.IRepositoryCallback
import bm.it.mobile.connector.sample.model.UserModel
import bm.it.mobile.connector.sample.presenter.ISamplePresenter
import bm.it.mobile.connector.sample.repository.ISampleRepository
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.ArgumentCaptor
import org.mockito.Captor
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner


@RunWith(MockitoJUnitRunner::class)
class SampleInteractorTest {

    @Mock
    private lateinit var presenter: ISamplePresenter

    @Mock
    private lateinit var repository: ISampleRepository

    @Captor
    private lateinit var argumentCaptor: ArgumentCaptor<IRepositoryCallback<*>>

    private lateinit var interactor: ISampleInteractor

    @Before
    fun setUp() {
        argumentCaptor = ArgumentCaptor.forClass(IRepositoryCallback::class.java)
        interactor = SampleInteractor(presenter, repository)
    }

    @Test
    fun getSampleFailureTest() {
        interactor.getSample()
        argumentCaptor.capture().onFailure()
        verify(presenter).showError()
    }
}
