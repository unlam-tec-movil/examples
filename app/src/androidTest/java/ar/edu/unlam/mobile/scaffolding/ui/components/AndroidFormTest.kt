package ar.edu.unlam.mobile.scaffolding.ui.components

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import androidx.test.ext.junit.runners.AndroidJUnit4
import ar.edu.unlam.mobile.scaffolding.domain.models.RealAndroid
import org.junit.Assert
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class AndroidFormTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testAndroidForm() {
        // Given
        val expected =
            RealAndroid(
                id = null,
                name = "Android 1",
                picture = "https://developer.android.com/images/brand/Android_Robot.png",
                description = "Android 1 description",
            )
        val givenOnSubmit = { result: RealAndroid -> Assert.assertEquals(expected, result) }
        composeTestRule.setContent {
            AndroidForm(
                onSubmit = givenOnSubmit,
            )
        }
        // When
        composeTestRule.onNodeWithText("Name").assertExists().performTextInput("Android 1")
        composeTestRule.onNodeWithText("Description").assertExists().performTextInput("Android 1 description")
        composeTestRule
            .onNodeWithText("Image URL")
            .assertExists()
            .performTextInput("https://developer.android.com/images/brand/Android_Robot.png")
        composeTestRule.onNodeWithText("Create").assertExists()
        // Then
        composeTestRule.onNodeWithText("Android 1").assertExists()
        composeTestRule.onNodeWithText("Android 1 description").assertExists()
        composeTestRule
            .onNodeWithText("https://developer.android.com/images/brand/Android_Robot.png")
            .assertExists()
        composeTestRule.onNodeWithText("Create").performClick()
    }
}
