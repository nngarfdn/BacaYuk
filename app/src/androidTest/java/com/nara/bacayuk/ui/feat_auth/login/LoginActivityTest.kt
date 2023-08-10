package com.nara.bacayuk.ui.feat_auth.login

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import com.nara.bacayuk.R
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class LoginActivityTest{

    @get:Rule
    var activityRule: ActivityScenarioRule<LoginActivity> = ActivityScenarioRule(
        LoginActivity::class.java)

    @Test
    fun testLogin() {
        Espresso.onView(withId(R.id.edt_email)).perform(ViewActions.typeText("testertab@gmail.com"), ViewActions.closeSoftKeyboard())
        Espresso.onView(withId(R.id.edt_password)).perform(ViewActions.typeText("12345678"),ViewActions.closeSoftKeyboard())
        Espresso.onView(withId(R.id.btn_login)).perform(ViewActions.click())
        //verify view in main activity
        Thread.sleep(4000)
        //check word "Pilih Siswa"
        Espresso.onView(withText("Pilih Siswa")).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }


}