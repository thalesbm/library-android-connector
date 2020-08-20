package bm.it.mobile.connector.sample.repository

import android.content.Context
import bm.it.mobile.connector.library.ConnectorApplication
import bm.it.mobile.connector.library.IConnectorCallback
import bm.it.mobile.connector.library.IRepositoryCallback
import bm.it.mobile.connector.library.enums.ConnectorType
import bm.it.mobile.connector.library.response.ConnectorFailureResponse
import bm.it.mobile.connector.sample.SampleURL
import bm.it.mobile.connector.sample.model.UserModel
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.*
import org.mockito.ArgumentMatchers.any
import org.mockito.Mockito.mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class SampleRepositoryTest {

    private lateinit var repository: ISampleRepository

    private lateinit var connector: ConnectorApplication

    @Mock
    private lateinit var callback: IRepositoryCallback<UserModel>

    @Captor
    private lateinit var argumentCaptor: ArgumentCaptor<IConnectorCallback>

    @Before
    fun setUp() {
        connector = ConnectorApplication.Builder()
            .setContext(mock(Context::class.java))
            .setBaseURL(SampleURL.BASE.url)
            .setType(ConnectorType.REST_API)
            .build()
        repository = SampleRepository(connector)
    }

    @Test
    fun getUsersTest() {
        repository.getUsers(callback)
        argumentCaptor.capture().onFailure(mock(ConnectorFailureResponse::class.java))
    }
}
