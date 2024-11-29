package com.abnamro.apps.referenceandroid

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.abnamro.apps.referenceandroid.pages.MainActivityPage
import org.junit.After
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    private val mainPage = MainActivityPage()

    @Before
    fun setUp() {
        mainPage.attachScenario(activityRule.scenario)
    }

    @After
    fun tearDown() {
        activityRule.scenario.close()
    }

    @Test
    fun testHelloWorldDisplayed() {
        mainPage.checkTextDisplayed("Hello World!")
    }

    @Test
    fun testToolbarIsDisplayed() {
        mainPage.checkViewDisplayed(R.id.toolbar)
    }

    @Test
    fun testFabIsDisplayed() {
        mainPage.checkViewDisplayed(R.id.fab)
    }

    @Test
    fun testToolbarTitle() {
        mainPage.checkToolbarTitle(R.string.app_name)
    }

    @Test
    fun testSnackbarDoesNotBlockFab() {
        mainPage.clickFab().checkViewDisplayed(R.id.fab)
    }

    @Test
    fun testMenuItems() {
        mainPage.openOptionsMenu()

        mainPage.checkTextDisplayed(R.string.action_settings)
            .checkTextEnabled(R.string.action_settings)
    }

    @Test
    fun testOrientationChange() {
        mainPage
            .rotateDeviceToLandscape()
            .checkViewDisplayed(R.id.toolbar)
            .rotateDeviceToPortrait()
            .checkViewDisplayed(R.id.toolbar)
    }

    @Test
    fun testKeyboardDoesNotOverlapUI() {
        mainPage.showKeyboard()
            .checkViewDisplayed(R.id.toolbar)
            .hideKeyboard()
            .checkViewDisplayed(R.id.fab)
    }

}
