package com.alurwa.gamecatalogue

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
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
class ToAboutTest {

    @get:Rule
    var activityTestRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun toAboutActivity() {
        onView(withId(R.id.about)).perform(click())

        onView(withId(R.id.card_profile)).check(matches(isDisplayed()))
        onView(withId(R.id.img_profile)).check(matches(isDisplayed()))
        onView(withId(R.id.txt_name)).check(matches(isDisplayed()))
        onView(withId(R.id.txt_email)).check(matches(isDisplayed()))
    }
}