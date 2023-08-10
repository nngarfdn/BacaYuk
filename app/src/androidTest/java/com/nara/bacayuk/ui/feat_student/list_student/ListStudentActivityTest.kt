package com.nara.bacayuk.ui.feat_student.list_student

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.nara.bacayuk.R
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class ListStudentActivityTest{

    @get:Rule
    var activityRule: ActivityScenarioRule<ListStudentActivity> = ActivityScenarioRule(
        ListStudentActivity::class.java
    )

    @Test
    fun testListStudent(){
        Thread.sleep(4000)
        onView(withId(R.id.rv_list_student)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun testEditStudent(){
        Thread.sleep(4000)
        onView(withId(R.id.rv_list_student))
            .perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(0))
            .perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.img_action_right)).perform(click())
        onView(ViewMatchers.withText("Edit Siswa")).perform(click())
        onView(withId(R.id.edt_name)).perform(ViewActions.typeText("edit"), ViewActions.closeSoftKeyboard())
        onView(withId(R.id.btn_save_student)).perform(click())
    }

    @Test
    fun testDeleteStudent(){
        Thread.sleep(4000)
        onView(withId(R.id.rv_list_student))
            .perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(1))
            .perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(1, click()))
        onView(withId(R.id.img_action_right)).perform(click())
        onView(ViewMatchers.withText("Hapus")).perform(click())
        onView(ViewMatchers.withText("Ya")).perform(click())
    }

    @Test
    fun tessAddStudent(){
        Thread.sleep(4000)
        onView(withId(R.id.img_action_right)).perform(click())
        onView(ViewMatchers.withText("Tambah Siswa")).perform(click())
        onView(withId(R.id.edt_name)).perform(ViewActions.typeText("test"), ViewActions.closeSoftKeyboard())
        onView(withId(R.id.edt_kelas)).perform(ViewActions.typeText("test"), ViewActions.closeSoftKeyboard())
        onView(withId(R.id.edt_noabsen)).perform(ViewActions.typeText("test"), ViewActions.closeSoftKeyboard())
        onView(withId(R.id.edt_asal_sekolah)).perform(ViewActions.typeText("test"), ViewActions.closeSoftKeyboard())
        onView(withId(R.id.edt_tahun_masuk_sekolah)).perform(ViewActions.typeText("test"), ViewActions.closeSoftKeyboard())
        onView(withId(R.id.btn_save_student)).perform(click())
    }

}