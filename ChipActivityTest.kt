package com.travels.searchtravels

import android.content.Context
import android.view.View
import android.widget.TextView
import androidx.lifecycle.Lifecycle
import androidx.test.core.app.ApplicationProvider
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.espresso.Espresso.onView
import com.travels.searchtravels.activity.ChipActivity

import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.closeSoftKeyboard
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.TypeSafeMatcher


@RunWith(AndroidJUnit4::class)
@LargeTest
class ChipActivityTest {
    @get:Rule
    val activityRule = ActivityScenarioRule(ChipActivity::class.java)

    @Test
    fun getInfoNomad_ReturnCorrectInformation() {
        val scenario = activityRule.scenario
        scenario.onActivity { activity -> activity.getInfoNomad("Rimini") }

        onView(withId(R.id.countryTV)).check(matches(withText("Italy")))
        onView(withId(R.id.cityTV)).check(matches(withText("Rimini")))
        onView(withId(R.id.airticketTV)).check(matches(matchFormatAndHaveNumbers()))
    }

    private fun matchFormatAndHaveNumbers(): Matcher<View> {
        return object : TypeSafeMatcher<View>() {
            public override fun matchesSafely(view: View): Boolean {
                val text = (view as TextView).text.toString()
                return text.startsWith("от") &&
                        text.matches("(\\w)?\\d+(\\.\\d+)?(\\w)?".toRegex()) &&
                        text.endsWith("\u20BD")
            }
            override fun describeTo(description: Description) {
                description.appendText("Text should contain numbers")
            }
        }
    }
}