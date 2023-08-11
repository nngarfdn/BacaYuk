package com.nara.bacayuk.ui.feat_riwayat.menu

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.nara.bacayuk.R
import com.nara.bacayuk.ui.feat_menu_utama.MainActivity
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MenuRiwayatActivityTest{

    @get:Rule
    var activityRule: ActivityScenarioRule<MenuRiwayatActivity> = ActivityScenarioRule(
        MenuRiwayatActivity::class.java
    )

    @Test
    fun checkMenuRiwayat(){
        Espresso.onView(ViewMatchers.withId(R.id.btn_huruf))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.btn_kata))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.btn_kalimat))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

}