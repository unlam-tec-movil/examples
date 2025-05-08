package ar.edu.unlam.mobile.scaffolding.ui.screens

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import androidx.test.ext.junit.runners.AndroidJUnit4
import ar.edu.unlam.mobile.scaffolding.domain.models.RealAndroid
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.kotlin.mock

@RunWith(AndroidJUnit4::class)
class AndroidCreateScreenTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testAndroidCreateScreen() {
        // Given
        val givenRealAndroid =
            RealAndroid(
                id = null,
                name = "Android 1",
                picture = "https://developer.android.com/images/brand/Android_Robot.png",
                description = "Android 1 description",
            )
        val vm =
            mock<AndroidCreateViewModel> {
                on { onSubmit(givenRealAndroid) }.then { }
            }
        composeTestRule.setContent {
            AndroidCreateScreen(vm)
        }
        // When
        composeTestRule.onNodeWithText("Name").assertExists().performTextInput("Android 1")
        composeTestRule.onNodeWithText("Description").assertExists().performTextInput("Android 1 description")
        composeTestRule
            .onNodeWithText("Image URL")
            .assertExists()
            .performTextInput("https://developer.android.com/images/brand/Android_Robot.png")
        composeTestRule.onNodeWithText("Create").assertExists().performClick()
    }
}
