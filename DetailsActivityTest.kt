package com.travels.searchtravels

import android.view.View
import android.widget.TextView
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.travels.searchtravels.activity.ChipActivity
import com.travels.searchtravels.activity.DetailsActivity
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.TypeSafeMatcher
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class DetailsActivityTest {
    @get:Rule
    val activityRule = ActivityScenarioRule(DetailsActivity::class.java)

    @Test
    fun getInfoNomad_ReturnCorrectInformation() {
        val scenario = activityRule.scenario
        scenario.onActivity { activity -> activity.getInfoNomad("Rimini") }

        onView(withId(R.id.countryTV)).check(matches(withText("Italy")))
        onView(withId(R.id.cityTV)).check(matches(withText("Rimini")))
        onView(withId(R.id.airticketTV)).check(matches(matchFormatAndHaveNumbers()))
        onView((withText(R.id.hotelsTV))).check(matches(matchFormatAndHaveNumbers()))
        onView(withId(R.id.shopTV)).check(matches(matchFormatAndHaveNumbers()))
        onView(withId(R.id.costListRV)).check(matches(isDisplayed()))
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