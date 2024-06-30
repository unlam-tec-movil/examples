package ar.edu.unlam.mobile.scaffolding.data.local

import ar.edu.unlam.mobile.scaffolding.domain.models.RealAndroid
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class AndroidRoomRepositoryTest {
    @Mock
    private lateinit var dao: AndroidDao

    @InjectMocks
    private lateinit var subject: AndroidRoomRepository

    @Test
    fun listAndroidsSuccess() {
        // Given
        runBlocking {
            val expected = listOf(RealAndroid("2b", 1u, "The best android", "https://www.google.com"))
            val entityStub = AndroidEntity(1, "2b", "The best android", "https://www.google.com")
            val daoResponseStub = flowOf(listOf(entityStub))
            Mockito.`when`(dao.listAndroids()).thenReturn(daoResponseStub)
            // When
            val result = subject.listAndroids()
            result.collect { actual ->
                // Then
                Assert.assertEquals(expected, actual)
            }
        }

        // Then
    }
}
