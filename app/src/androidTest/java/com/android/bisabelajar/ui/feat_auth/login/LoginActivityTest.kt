package com.android.bisabelajar.ui.feat_auth.login

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.android.bisabelajar.R
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class LoginActivityTest{

    @get:Rule
    var activityRule: ActivityScenarioRule<LoginActivity> = ActivityScenarioRule(LoginActivity::class.java)

    @Test
    fun testLoginSuccess() {
        Espresso.onView(withId(R.id.edt_email)).perform(ViewActions.typeText("nanang@gmail.com"), ViewActions.closeSoftKeyboard())
        Espresso.onView(withId(R.id.edt_password)).perform(ViewActions.typeText("12345678"),ViewActions.closeSoftKeyboard())
        Espresso.onView(withId(R.id.btn_login)).perform(ViewActions.click())
        //verify view in main activity
        Thread.sleep(2000)
        Espresso.onView(withId(R.id.btn_abjad_kapital)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun testRegisterSuccess() {
        Espresso.onView(withId(R.id.txt_daftar)).perform(ViewActions.click())
        //verify view in main activity
        Thread.sleep(2000)
        Espresso.onView(withId(R.id.txt_masuk)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.edt_name)).perform(ViewActions.typeText("Nanang"), ViewActions.closeSoftKeyboard())
        //generate random email
        val email = "nanang" + System.currentTimeMillis() + "@gmail.com"
        Espresso.onView(withId(R.id.edt_email)).perform(ViewActions.typeText(email), ViewActions.closeSoftKeyboard())
        Espresso.onView(withId(R.id.edt_password)).perform(ViewActions.typeText("12345678"),ViewActions.closeSoftKeyboard())
        Espresso.onView(withId(R.id.edt_password_confirmation)).perform(ViewActions.typeText("12345678"),ViewActions.closeSoftKeyboard())
        Espresso.onView(withId(R.id.btn_daftar)).perform(ViewActions.click())
        //verify view in main activity
        Thread.sleep(2000)
        Espresso.onView(withId(R.id.btn_abjad_kapital)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }
}