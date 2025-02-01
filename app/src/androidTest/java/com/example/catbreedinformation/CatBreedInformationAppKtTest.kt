package com.example.catbreedinformation

import android.content.Context
import androidx.activity.ComponentActivity
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertTextContains
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performScrollToIndex
import androidx.compose.ui.test.performTextInput
import androidx.navigation.compose.ComposeNavigator
import androidx.navigation.testing.TestNavHostController
import androidx.test.platform.app.InstrumentationRegistry
import com.example.catbreedinformation.data.local.fake.FakeCatBreedDataSource
import com.example.catbreedinformation.navigation.Screen
import com.example.catbreedinformation.ui.theme.CatBreedInformationTheme
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class CatBreedInformationAppKtTest {

    private lateinit var appContext: Context

    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()
    private lateinit var navController: TestNavHostController

    @Before
    fun setUp() {
        appContext = InstrumentationRegistry.getInstrumentation().targetContext

        composeTestRule.setContent {
            CatBreedInformationTheme {
                navController = TestNavHostController(LocalContext.current)
                navController.navigatorProvider.addNavigator(ComposeNavigator())
                CatBreedInformationApp(
                    navController = navController,
                    modifier = Modifier
                )
            }
        }
    }

    @Test
    fun verifyStartDestination() { navController.assertCurrentRouteName(Screen.Home.route) }

    @Test
    fun verifyFavoriteDestination() {
        // somehow i need to do this so it will work, otherwise it not work
        composeTestRule.runOnUiThread { navController.navigate(Screen.Favorite.route) }
        composeTestRule.waitForIdle()
        navController.assertCurrentRouteName(Screen.Favorite.route)
    }

    @Test
    fun verifyAboutDestination() {
        composeTestRule.runOnUiThread { navController.navigate(Screen.About.route) }
        composeTestRule.waitForIdle()
        navController.assertCurrentRouteName(Screen.About.route) }

    @Test
    fun verifyAllDetailDataIsCorrect() {
        navController.assertCurrentRouteName(Screen.Home.route)

        val context = composeTestRule.activity
        val catBreeds = FakeCatBreedDataSource.getAll(context)

        for (i in 0..10) {
            composeTestRule.onNodeWithTag("catBreedList").performScrollToIndex(i)
            composeTestRule.onNodeWithText(catBreeds[i].name).performClick()

            composeTestRule.onNodeWithTag("catBreedName").assertTextContains(catBreeds[i].name)

            composeTestRule.onNodeWithTag("catBreedOrigin").assertTextContains(
                context.getString(R.string.label_origin, catBreeds[i].origin)
            )

            composeTestRule.onNodeWithTag("catBreedLifeSpan").assertTextContains(
                context.getString(R.string.label_life_span, catBreeds[i].lifespan)
            )

            composeTestRule.onNodeWithTag("catBreedAppearance").assertTextContains(
                context.getString(R.string.label_appearance, catBreeds[i].appearance)
            )

            composeTestRule.onNodeWithTag("catBreedDescription").assertTextContains(catBreeds[i].description)

            composeTestRule.onNodeWithTag("backToHome").performClick()
        }
    }

    @Test
    fun verifySearchResultNotEmptyAndTheSearchResultDetailIsCorrect() {
        val context = composeTestRule.activity
        val maineCoon = FakeCatBreedDataSource.getAll(context)[5]

        navController.assertCurrentRouteName(Screen.Home.route)

        composeTestRule.onNodeWithTag("searchBar").performTextInput(maineCoon.name)

        composeTestRule.onNodeWithTag("searchResult").performClick()

        composeTestRule.onNodeWithTag("catBreedName").assertTextContains(maineCoon.name)

        composeTestRule.onNodeWithTag("catBreedOrigin").assertTextContains(
            context.getString(R.string.label_origin, maineCoon.origin)
        )
        composeTestRule.onNodeWithTag("catBreedLifeSpan").assertTextContains(
            context.getString(R.string.label_life_span, maineCoon.lifespan)
        )

        composeTestRule.onNodeWithTag("catBreedAppearance").assertTextContains(
            context.getString(R.string.label_appearance, maineCoon.appearance)
        )

        composeTestRule.onNodeWithTag("catBreedDescription").assertTextContains(maineCoon.description)

        composeTestRule.onNodeWithTag("backToHome").performClick()
    }

    // negative case for search result
    @Test
    fun verifyThatIfSearchResultEmptyItDisplayNoDataFound() {
        val context = composeTestRule.activity
        navController.assertCurrentRouteName(Screen.Home.route)
        composeTestRule.onNodeWithTag("searchBar").performTextInput("nguwawor loh ya rek")
        composeTestRule.onNodeWithText(context.getString(R.string.label_no_data_found)).assertIsDisplayed()
    }

    @Test
    fun verifyThatFavoriteButtonWorkAndExistOnFavoriteScreenAndTheDetailDataIsCorrect() {
        val context = composeTestRule.activity
        val maineCoon = FakeCatBreedDataSource.getAll(context)[5]

        navController.assertCurrentRouteName(Screen.Home.route)
        composeTestRule.onNodeWithTag("catBreedList").performScrollToIndex(5)
        composeTestRule.onNodeWithText(maineCoon.name).performClick()
        composeTestRule.onNodeWithTag("favorite").performClick()

        // go to home again
        composeTestRule.onNodeWithTag("backToHome").performClick()

        // go to favorite
        composeTestRule.runOnUiThread { navController.navigate(Screen.Favorite.route) }
        composeTestRule.waitForIdle()
        navController.assertCurrentRouteName(Screen.Favorite.route)

        // the check the result, in this case maine coon is in favorite and check if the data is correct
        composeTestRule.onNodeWithText(maineCoon.name).performClick()
        composeTestRule.onNodeWithTag("catBreedName").assertTextContains(maineCoon.name)
        composeTestRule.onNodeWithTag("catBreedOrigin").assertTextContains(
            context.getString(R.string.label_origin, maineCoon.origin)
        )
        composeTestRule.onNodeWithTag("catBreedLifeSpan").assertTextContains(
            context.getString(R.string.label_life_span, maineCoon.lifespan)
        )
        composeTestRule.onNodeWithTag("catBreedAppearance").assertTextContains(
            context.getString(R.string.label_appearance, maineCoon.appearance)
        )
        composeTestRule.onNodeWithTag("catBreedDescription").assertTextContains(maineCoon.description)
        composeTestRule.onNodeWithTag("backToHome").performClick()
    }


    // negative case for favorite (data empty)
    @Test
    fun verifyThatDataInFavoriteIsEmpty() {
        val context = composeTestRule.activity
        navController.assertCurrentRouteName(Screen.Home.route)

        // go to favorite
        composeTestRule.runOnUiThread { navController.navigate(Screen.Favorite.route) }
        composeTestRule.waitForIdle()
        navController.assertCurrentRouteName(Screen.Favorite.route)
        composeTestRule.onNodeWithText(context.getString(R.string.label_no_data_found)).assertIsDisplayed()
    }

    // negative case for favorite (perform un-favorite)
    @Test
    fun verifyThatPerformingUnFavoriteIsSuccess() {
        val context = composeTestRule.activity
        val maineCoon = FakeCatBreedDataSource.getAll(context)[5]

        navController.assertCurrentRouteName(Screen.Home.route)
        composeTestRule.onNodeWithTag("catBreedList").performScrollToIndex(5)
        composeTestRule.onNodeWithText(maineCoon.name).performClick()

        // perform favorite
        composeTestRule.onNodeWithTag("favorite").performClick()

        // then click again so it get UN-FAVORITE
        composeTestRule.onNodeWithTag("favorite").performClick()

        // go to home
        composeTestRule.onNodeWithTag("backToHome").performClick()

        // go to favorite
        composeTestRule.runOnUiThread { navController.navigate(Screen.Favorite.route) }
        composeTestRule.waitForIdle()
        navController.assertCurrentRouteName(Screen.Favorite.route)

        // the no data suppose to be displayed
        composeTestRule.onNodeWithText(context.getString(R.string.label_no_data_found)).assertIsDisplayed()
    }
}