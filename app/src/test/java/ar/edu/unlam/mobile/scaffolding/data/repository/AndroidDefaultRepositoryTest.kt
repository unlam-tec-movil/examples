package ar.edu.unlam.mobile.scaffolding.data.repository

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
import org.mockito.kotlin.any
import org.mockito.kotlin.doAnswer
import org.mockito.kotlin.mock
import org.mockito.kotlin.never

@RunWith(MockitoJUnitRunner::class)
class AndroidDefaultRepositoryTest {
    @Mock
    private lateinit var local: AndroidLocalRepository

    @InjectMocks
    private lateinit var subject: AndroidDefaultRepository

    @Test
    fun listAndroidsSuccess() {
        // Given
        val androidStub = RealAndroid("2b", 1u, "The best android", "https://www.google.com")
        val expected = flowOf(listOf(androidStub))
        Mockito.`when`(local.listAndroids()).thenReturn(expected)
        // When
        val actual = subject.listAndroids()
        // Then
        Assert.assertEquals(expected, actual)
        Mockito.verify(local).listAndroids()
        Mockito.verifyNoMoreInteractions(local)
        runBlocking {
            Mockito.verify(local, never()).createAndroid(any())
        }
    }

    @Test
    fun createAndroidSuccess() {
        // Given
        val androidStub = RealAndroid("2b", 1u, "The best android", "https://www.google.com")
        val localRepo =
            mock<AndroidLocalRepository> {
                onBlocking { createAndroid(any()) } doAnswer { }
            }
        val subject = AndroidDefaultRepository(localRepo)
        // When
        runBlocking {
            subject.createAndroid(androidStub)
            // Then
            Mockito.verify(localRepo).createAndroid(androidStub)
            Mockito.verifyNoMoreInteractions(localRepo)
        }
    }
}
