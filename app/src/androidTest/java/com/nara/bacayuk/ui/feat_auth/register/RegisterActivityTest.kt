package com.nara.bacayuk.ui.feat_auth.register

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.uiautomator.UiDevice
import com.nara.bacayuk.R
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class RegisterActivityTest{

    @get:Rule
    var activityRule: ActivityScenarioRule<RegisterActivity> = ActivityScenarioRule(
        RegisterActivity::class.java)


    @Test
    fun testRegister() {
        Espresso.onView(ViewMatchers.withId(R.id.edt_name)).perform(ViewActions.typeText("Nanang"), ViewActions.closeSoftKeyboard())
        //generate random email
        val email = "nanang" + System.currentTimeMillis() + "@gmail.com"
        Espresso.onView(ViewMatchers.withId(R.id.edt_email)).perform(ViewActions.typeText(email), ViewActions.closeSoftKeyboard())
        Espresso.onView(ViewMatchers.withId(R.id.edt_password)).perform(
            ViewActions.typeText("12345678"),
            ViewActions.closeSoftKeyboard())
        Espresso.onView(ViewMatchers.withId(R.id.edt_password_confirmation)).perform(
            ViewActions.typeText("12345678"),
            ViewActions.closeSoftKeyboard())
        Thread.sleep(2000)
        Espresso.onView(ViewMatchers.withId(R.id.btn_register)).perform(ViewActions.click())
        //verify view in login activity
        Thread.sleep(4000)
        Espresso.onView(ViewMatchers.withId(R.id.txt_forgot_password)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }


}