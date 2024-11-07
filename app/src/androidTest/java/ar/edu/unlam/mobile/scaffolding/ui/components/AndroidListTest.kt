package ar.edu.unlam.mobile.scaffolding.ui.components

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.test.ext.junit.runners.AndroidJUnit4
import ar.edu.unlam.mobile.scaffolding.domain.models.RealAndroid
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class AndroidListTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun androidListComponentTest() {
        // Given
        val androidList =
            listOf(
                RealAndroid(
                    id = 1u,
                    name = "Android 1",
                    picture = "https://developer.android.com/images/brand/Android_Robot.png",
                    description = "Android 1 description",
                ),
                RealAndroid(
                    id = 2u,
                    name = "Android 2",
                    picture = "https://developer.android.com/images/brand/Android_Robot.png",
                    description = "Android 2 description",
                ),
            )
        // When
        composeTestRule.setContent {
            AndroidList(androidList = androidList)
        }
        // Then
        composeTestRule.onNodeWithText("Android 1").assertExists()
        composeTestRule.onNodeWithText("Android 1 description").assertExists()
        composeTestRule.onNodeWithText("Android 2").assertExists()
        composeTestRule.onNodeWithText("Android 2 description").assertExists()
    }
}
