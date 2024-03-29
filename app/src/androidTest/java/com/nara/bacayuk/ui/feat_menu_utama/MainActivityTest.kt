package com.nara.bacayuk.ui.feat_menu_utama

import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.nara.bacayuk.R
import com.nara.bacayuk.ui.feat_auth.forgot_password.ForgotPasswordActivity
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest{
    @get:Rule
    var activityRule: ActivityScenarioRule<MainActivity> = ActivityScenarioRule(
        MainActivity::class.java
    )

    @Test
    fun testLogout(){
        onView(withId(R.id.img_action_right)).perform(ViewActions.click())
        onView(ViewMatchers.withText("Keluar")).perform(ViewActions.click())
        onView(ViewMatchers.withText("Ya")).perform(ViewActions.click())
        onView(withId(R.id.txt_forgot_password)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun checkMenu(){
        onView(withId(R.id.btn_riwayat)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(withId(R.id.btn_baca_huruf)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(withId(R.id.btn_baca_kata)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(withId(R.id.btn_baca_kalimat)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }



}