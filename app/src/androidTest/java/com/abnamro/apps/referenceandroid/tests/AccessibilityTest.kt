package com.abnamro.apps.referenceandroid

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.abnamro.apps.referenceandroid.pages.MainActivityPage
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class AccessibilityTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    private val mainPage = MainActivityPage()

    @Before
    fun setUp() {
        mainPage.attachScenario(activityRule.scenario)
    }

    @Test
    fun testContentDescriptionForToolbar() {
        mainPage.checkContentDescription(R.id.toolbar)
    }

    @Test
    fun testContentDescriptionForFab() {
        mainPage.checkContentDescription(R.id.fab)
    }

//    @Test
//    fun testContentDescriptionForMenuItems() {
//        mainPage
//            .openOptionsMenu()
//            .checkTextDisplayed(R.string.action_settings)
//            .checkContentDescription(R.id.action_settings)
//    }

}
