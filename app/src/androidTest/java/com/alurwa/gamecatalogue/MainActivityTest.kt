package com.alurwa.gamecatalogue

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewAction
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.matcher.IntentMatchers
import androidx.test.espresso.intent.rule.IntentsTestRule
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.hasDescendant
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.alurwa.gamecatalogue.adapter.GameAdapter
import com.alurwa.gamecatalogue.utils.DataDummy
import org.hamcrest.Matchers.allOf
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Created by Purwa Shadr Al 'urwa on 01/07/2021
 */

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @get:Rule
    var activityTestRule = ActivityScenarioRule(MainActivity::class.java)

    @get:Rule
    var intentTestRule = IntentsTestRule(MainActivity::class.java)

    @Test
    fun scrollToItemBelowFold_checkItsText() {
        // First scroll to the position that needs to be matched and click on it.
        onView(withId(R.id.list_game))
            .perform(
                RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(9)
            )

        // Match the text in an item below the fold and check that it's displayed.
        val itemElementText = DataDummy.gameList[9].title
        onView(withText(itemElementText)).check(
            ViewAssertions.matches(ViewMatchers.isDisplayed())
        )
    }

    // Masih bingung
    @Test
    fun itemWithText_doesNotExist() {
        // Attempt to scroll to an item that contains the special text.
        onView(withId(R.id.list_game)) // scrollTo will fail the test if no item matches.
            .perform(
                RecyclerViewActions.scrollTo<RecyclerView.ViewHolder>(
                    hasDescendant(withText(DataDummy.gameList[9].title))
                )
            )
    }

    @Test
    fun validateIntent() {
        onView(withId(R.id.list_game))
            .perform(
                RecyclerViewActions.actionOnItemAtPosition<GameAdapter.ViewHolder>(
                    0,
                    click()
                )
            )

        intended(
            allOf(
                IntentMatchers.toPackage("com.alurwa.gamecatalogue"),
                IntentMatchers.hasExtra(DetailActivity.EXTRA_GAME, DataDummy.gameList[0])
            )
        )
    }
}