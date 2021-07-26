package com.alurwa.gamecatalogue

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.scrollTo
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Created by Purwa Shadr Al 'urwa on 14/07/2021
 */

@RunWith(AndroidJUnit4::class)
class ToDetailActivityTest {

    @get:Rule
    var activityTestRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun toDetailActivity() {
        onView(withId(R.id.list_game)).check(matches(isDisplayed()))
        onView(withId(R.id.list_game)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )

        onView(withId(R.id.txt_title)).perform(scrollTo()).check(matches(isDisplayed()))
        onView(withId(R.id.txt_score)).perform(scrollTo()).check(matches(isDisplayed()))
        onView(withId(R.id.txt_overview)).perform(scrollTo())
            .check(matches(isDisplayed()))
        onView(withId(R.id.txt_genres)).perform(scrollTo())
            .check(matches(isDisplayed()))
        onView(withId(R.id.txt_first_release)).perform(scrollTo())
            .check(matches(isDisplayed()))
        onView(withId(R.id.txt_publisher)).perform(scrollTo())
            .check(matches(isDisplayed()))
        onView(withId(R.id.txt_developer)).perform(scrollTo())
            .check(matches(isDisplayed()))
    }
}