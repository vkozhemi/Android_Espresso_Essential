package com.example.android_espresso_essential

import androidx.appcompat.widget.Toolbar
import android.view.View

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.BoundedMatcher
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.rule.ActivityTestRule


import org.hamcrest.CoreMatchers.not
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.junit.Test

import org.junit.Rule
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @Rule
    @JvmField
    var activityRule = ActivityTestRule<MainActivity> (MainActivity::class.java)

    @Test
    fun greet() {
        onView(withId(R.id.greeting)).check(matches(withText("")));
        onView(withId(R.id.greet_button)).perform(click()).check(matches(not(isEnabled())))
        onView(withId(R.id.greeting)).check(matches(withText(R.string.hello)));
    }

    @Test
    fun toolbarTitle() {
        val title = InstrumentationRegistry.getInstrumentation().targetContext.getString(R.string.title)

        onView(isAssignableFrom(Toolbar::class.java))
            .check(matches(withToolbarTitle(title)))
    }

    private fun withToolbarTitle(expectedTitle: CharSequence): Matcher<View> {
        return object : BoundedMatcher<View, Toolbar>(Toolbar::class.java) {

            override fun describeTo(description: Description?) {
                description?.appendText("with toolbar title: $expectedTitle")
            }

            override fun matchesSafely(toolbar: Toolbar?): Boolean {
                return expectedTitle == toolbar?.title
            }

        }
    }
}