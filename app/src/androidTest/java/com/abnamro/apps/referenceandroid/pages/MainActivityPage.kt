package com.abnamro.apps.referenceandroid.pages

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.openActionBarOverflowOrOptionsMenu
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.assertion.ViewAssertions.doesNotExist
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.platform.app.InstrumentationRegistry
import com.abnamro.apps.referenceandroid.R

class MainActivityPage {

    // Universal method to check if text is displayed
    fun checkTextDisplayed(textResourceId: String): MainActivityPage {
        onView(withText(textResourceId)).check(matches(isDisplayed()))
        return this
    }

    // Universal method to check if any view is displayed
    fun checkViewDisplayed(viewId: Int): MainActivityPage {
        onView(withId(viewId)).check(matches(isDisplayed()))
        return this
    }

    // Check the title in the Toolbar
    fun checkToolbarTitle(titleResourceId: Int): MainActivityPage {
        onView(withId(R.id.toolbar))
            .check(matches(hasDescendant(withText(titleResourceId))))
        return this
    }

    // Click the FAB (Floating Action Button)
    fun clickFab(): MainActivityPage {
        onView(withId(R.id.fab)).perform(click())
        return this
    }

    // Open the menu
    fun openOptionsMenu(): MainActivityPage {
        openActionBarOverflowOrOptionsMenu(InstrumentationRegistry.getInstrumentation().targetContext)
        return this
    }

    // Check that the text is displayed
    fun checkTextDisplayed(textResourceId: Int): MainActivityPage {
        onView(withText(textResourceId)).check(matches(isDisplayed()))
        return this
    }

    // Check that the text is not disabled
    fun checkTextEnabled(textResourceId: Int): MainActivityPage {
        onView(withText(textResourceId)).check(matches(isEnabled()))
        return this
    }

    //This is required for performing device orientation changes
    private lateinit var scenario: ActivityScenario<*>

    fun attachScenario(scenario: ActivityScenario<*>): MainActivityPage {
        this.scenario = scenario
        return this
    }

    //Rotates the device to landscape orientation.
    fun rotateDeviceToLandscape(): MainActivityPage {
        scenario.onActivity { activity ->
            activity.requestedOrientation = android.content.pm.ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
        }
        return this
    }

    // Rotates the device back to portrait orientation
    fun rotateDeviceToPortrait(): MainActivityPage {
        scenario.onActivity { activity ->
            activity.requestedOrientation = android.content.pm.ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        }
        return this
    }

//    fun pressBackButton(): MainActivityPage {
//        Espresso.pressBack()
//        return this
//    }

    // Add logic to trigger the keyboard display
    fun showKeyboard(): MainActivityPage {
        return this
    }

    // Add logic to hide the keyboard
    fun hideKeyboard(): MainActivityPage {
        return this
    }

    // Universal method to check if contentDescription is set for a view
    fun checkContentDescription(viewId: Int): MainActivityPage {
        onView(withId(viewId))
            .check(matches(hasContentDescription()))
        return this
    }

}

