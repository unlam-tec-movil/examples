package ar.edu.unlam.mobile.scaffolding.ui.components

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class GreetingTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun greetingComponentTest() {
        // Given
        val givenName = "Android"
        composeTestRule.setContent {
            Greeting(name = givenName)
        }
        composeTestRule.onNodeWithText("Hello $givenName!").assertExists()
    }
}
