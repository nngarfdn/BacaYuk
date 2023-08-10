package com.nara.bacayuk.ui.feat_auth.forgot_password

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.nara.bacayuk.R
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ForgotPasswordActivityTest {

    @get:Rule
    var activityRule: ActivityScenarioRule<ForgotPasswordActivity> = ActivityScenarioRule(
        ForgotPasswordActivity::class.java
    )

    @Test
    fun testForgotPassword() {
        onView(withId(R.id.edt_email)).perform(
            ViewActions.typeText("testertab@gmail.com"),
            ViewActions.closeSoftKeyboard()
        )
        onView(withId(R.id.btn_login)).perform(click())
        Thread.sleep(1000)
        onView(withText("Ya")).perform(click())
    }
}

