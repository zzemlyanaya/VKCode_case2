package com.travels.searchtravels

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.travels.searchtravels.activity.DetailsActivity
import com.travels.searchtravels.activity.MainActivity
import com.travels.searchtravels.utils.Constants
import junit.framework.Assert.assertTrue
import org.hamcrest.Matchers.not
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith



@RunWith(AndroidJUnit4::class)
@LargeTest
class MainActivityTest {
    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    // assuming that loadByCategory() is not private method
    @Test
    fun loadByCategory_HandleSeaCorrect(){
        val scenario = activityRule.scenario
                scenario.onActivity { activity -> activity.loadByCategory("sea")}
        assertTrue("Should be Rimini !", Constants.PICKED_CITY_EN == "Rimini")
        onView(withId(R.id.progressRL))
            .check(matches(not(isDisplayed())))
        intended(hasComponent(DetailsActivity::class.java.name))
        scenario.recreate()
    }

    @Test
    fun loadByCategory_HandleOceanCorrect(){
        val scenario = activityRule.scenario
        scenario.onActivity { activity -> activity.loadByCategory("ocean")}
        assertTrue("Should be Rimini !", Constants.PICKED_CITY_EN == "Rimini")
        onView(withId(R.id.progressRL))
            .check(matches(not(isDisplayed())))
        intended(hasComponent(DetailsActivity::class.java.name))
        scenario.recreate()
    }

    @Test
    fun loadByCategory_HandleBeachCorrect(){
        val scenario = activityRule.scenario
        scenario.onActivity { activity -> activity.loadByCategory("beach")}
        assertTrue("Should be Rimini !", Constants.PICKED_CITY_EN == "Rimini")
        onView(withId(R.id.progressRL))
            .check(matches(not(isDisplayed())))
        intended(hasComponent(DetailsActivity::class.java.name))
        scenario.recreate()
    }

    @Test
    fun loadByCategory_HandleMountainCorrect(){
        val scenario = activityRule.scenario
        scenario.onActivity { activity -> activity.loadByCategory("mountain")}
        assertTrue("Should be Sochi !", Constants.PICKED_CITY_EN == "Sochi")
        onView(withId(R.id.progressRL))
            .check(matches(not(isDisplayed())))
        intended(hasComponent(DetailsActivity::class.java.name))
        scenario.recreate()
    }

    @Test
    fun loadByCategory_HandleSnowCorrect(){
        val scenario = activityRule.scenario
        scenario.onActivity { activity -> activity.loadByCategory("snow")}
        assertTrue("Should be Helsinki !", Constants.PICKED_CITY_EN == "Helsinki")
        onView(withId(R.id.progressRL))
            .check(matches(not(isDisplayed())))
        intended(hasComponent(DetailsActivity::class.java.name))
        scenario.recreate()
    }

    @Test
    fun loadByCategory_HandleOtherCorrect(){
        val scenario = activityRule.scenario
        scenario.onActivity { activity -> activity.loadByCategory("sth")}
        assertTrue("Should be Rimini !", Constants.PICKED_CITY_EN == "Rimini")
        onView(withId(R.id.progressRL))
            .check(matches(not(isDisplayed())))
        intended(hasComponent(DetailsActivity::class.java.name))
        scenario.recreate()
    }
}