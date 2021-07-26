package com.alurwa.gamecatalogue

import android.content.Intent
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.scrollTo
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.alurwa.gamecatalogue.utils.DataDummy
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Created by Purwa Shadr Al 'urwa on 14/07/2021
 */

@RunWith(AndroidJUnit4::class)
class DetailActivityTest {

    private val game = DataDummy.gameList[0]

    @get:Rule
    val activityScenarioRule = ActivityScenarioRule<DetailActivity>(
        Intent(
            InstrumentationRegistry.getInstrumentation().targetContext,
            DetailActivity::class.java
        ).putExtra(DetailActivity.EXTRA_GAME, game)
    )

    @Test
    fun views_validValue() {
        onView(withId(R.id.txt_title)).check(matches(isDisplayed()))
        onView(withId(R.id.txt_title)).check(matches(withText(game.title)))
        onView(withId(R.id.txt_score)).check(matches(isDisplayed()))
        onView(withId(R.id.txt_score)).check(matches(withText(game.score.toString())))
        onView(withId(R.id.txt_overview)).check(matches(isDisplayed()))
        onView(withId(R.id.txt_overview)).check(matches(withText(game.overview)))
        onView(withId(R.id.txt_genres)).perform(scrollTo()).check(matches(isDisplayed()))
        onView(withId(R.id.txt_genres)).check(matches(withText(game.genres)))
        onView(withId(R.id.txt_first_release)).perform(scrollTo()).check(matches(isDisplayed()))
        onView(withId(R.id.txt_first_release)).check(matches(withText(game.firstRelease)))
        onView(withId(R.id.txt_publisher)).perform(scrollTo()).check(matches(isDisplayed()))
        onView(withId(R.id.txt_publisher)).check(matches(withText(game.publisher)))
        onView(withId(R.id.txt_developer)).perform(scrollTo()).check(matches(isDisplayed()))
        onView(withId(R.id.txt_developer)).check(matches(withText(game.developer)))
    }
}