package com.nara.bacayuk.ui.feat_student.list_student

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.action.CoordinatesProvider
import androidx.test.espresso.action.GeneralSwipeAction
import androidx.test.espresso.action.Press
import androidx.test.espresso.action.Swipe
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.isDisplayingAtLeast
import androidx.test.espresso.matcher.ViewMatchers.isEnabled
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.espresso.util.TreeIterables
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.nara.bacayuk.R
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers
import org.hamcrest.TypeSafeMatcher
import org.hamcrest.core.AllOf.allOf
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class ListStudentActivityTest {

    @get:Rule
    var activityRule: ActivityScenarioRule<ListStudentActivity> = ActivityScenarioRule(
        ListStudentActivity::class.java
    )

    @Test
    fun testListStudent() {
        Thread.sleep(4000)
        onView(withId(R.id.rv_list_student)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun testEditStudent() {
        Thread.sleep(4000)
        onView(withId(R.id.rv_list_student))
            .perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(0))
            .perform(
                RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                    0,
                    click()
                )
            )
        onView(withId(R.id.img_action_right)).perform(click())
        onView(ViewMatchers.withText("Edit Siswa")).perform(click())
        onView(withId(R.id.edt_name)).perform(
            ViewActions.typeText("edit"),
            ViewActions.closeSoftKeyboard()
        )
        onView(withId(R.id.btn_save_student)).perform(click())
    }

    @Test
    fun testDeleteStudent() {
        Thread.sleep(4000)
        onView(withId(R.id.rv_list_student))
            .perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(1))
            .perform(
                RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                    1,
                    click()
                )
            )
        onView(withId(R.id.img_action_right)).perform(click())
        onView(ViewMatchers.withText("Hapus")).perform(click())
        onView(ViewMatchers.withText("Ya")).perform(click())
    }

    @Test
    fun tessAddStudent() {
        Thread.sleep(4000)
        onView(withId(R.id.img_action_right)).perform(click())
        onView(ViewMatchers.withText("Tambah Siswa")).perform(click())
        onView(withId(R.id.edt_name)).perform(
            ViewActions.typeText("test"),
            ViewActions.closeSoftKeyboard()
        )
        onView(withId(R.id.edt_kelas)).perform(
            ViewActions.typeText("test"),
            ViewActions.closeSoftKeyboard()
        )
        onView(withId(R.id.edt_noabsen)).perform(
            ViewActions.typeText("test"),
            ViewActions.closeSoftKeyboard()
        )
        onView(withId(R.id.edt_asal_sekolah)).perform(
            ViewActions.typeText("test"),
            ViewActions.closeSoftKeyboard()
        )
        onView(withId(R.id.edt_tahun_masuk_sekolah)).perform(
            ViewActions.typeText("test"),
            ViewActions.closeSoftKeyboard()
        )
        onView(withId(R.id.btn_save_student)).perform(click())
    }

    @Test
    fun checkRiwayatHuruf() {
        Thread.sleep(4000)
        onView(withId(R.id.rv_list_student))
            .perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(0))
            .perform(
                RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                    0,
                    click()
                )
            )
        onView(withId(R.id.btn_select_student)).perform(click())
        Thread.sleep(2000)
        onView(withId(R.id.btn_riwayat)).perform(click())
        Thread.sleep(2000)
        onView(withId(R.id.btn_huruf))
            .perform(click())
        Thread.sleep(4000)
        onView(withId(R.id.rv_riwayat_huruf))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun checkRiwayatKata() {
        Thread.sleep(4000)
        onView(withId(R.id.rv_list_student))
            .perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(0))
            .perform(
                RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                    0,
                    click()
                )
            )
        onView(withId(R.id.btn_select_student)).perform(click())
        Thread.sleep(2000)
        onView(withId(R.id.btn_riwayat)).perform(click())
        Thread.sleep(2000)
        onView(withId(R.id.btn_kata))
            .perform(click())
        Thread.sleep(4000)
        //go to RiwayatHurufActivity
        onView(withId(R.id.txt_a))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(withId(R.id.txt_i))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(withId(R.id.txt_u))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(withId(R.id.txt_e))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(withId(R.id.txt_o))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(withId(R.id.placeholder_belajar_suku))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        withCount("Level 1", 2)
    }

    @Test
    fun checkRiwayatKalimat() {
        Thread.sleep(4000)
        onView(withId(R.id.rv_list_student))
            .perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(0))
            .perform(
                RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                    0,
                    click()
                )
            )
        onView(withId(R.id.btn_select_student)).perform(click())
        Thread.sleep(2000)
        onView(withId(R.id.btn_riwayat)).perform(click())
        Thread.sleep(2000)
        onView(withId(R.id.btn_kalimat))
            .perform(click())
        Thread.sleep(4000)
        withCount("Level 1", 2)
    }

    fun withCount(text: String, expectedCount: Int): Matcher<View> =
        object : TypeSafeMatcher<View>() {
            override fun describeTo(description: Description?) {
                description?.appendText("with $expectedCount instances")
            }

            override fun matchesSafely(item: View?): Boolean {
                val actualCount = TreeIterables.breadthFirstViewTraversal(item).filter { view ->
                    withText("Level 1").matches(view)
                }.count()
                return actualCount == expectedCount
            }
        }

    @Test
    fun checkMenuBacaHuruf() {
        Thread.sleep(4000)
        onView(withId(R.id.rv_list_student))
            .perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(0))
            .perform(
                RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                    0,
                    click()
                )
            )
        onView(withId(R.id.btn_select_student)).perform(click())
        Thread.sleep(2000)
        onView(withId(R.id.btn_baca_huruf)).perform(click())
        Thread.sleep(3000)
        for (char in 'a'..'z') {
            onView(withText(char.toString()))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        }
    }

    @Test
    fun testMateriBacaHuruf() {
        checkMenuBacaHuruf()
        onView(withText("b")).perform(click())
        Thread.sleep(3000)
        onView(ViewMatchers.withText("Lanjutkan")).perform(click())
        Thread.sleep(3000)
        onView(ViewMatchers.withText("Lanjutkan")).perform(click())
        Thread.sleep(3000)
        onView(ViewMatchers.withText("Lanjutkan")).perform(click())
    }

    @Test
    fun tesQuizBacaHuruf() {
        testMateriBacaHuruf()
        Thread.sleep(3000)
        onView(ViewMatchers.withText("Lanjutkan")).perform(click())
        Thread.sleep(3000)
        onView(ViewMatchers.withText("Lanjutkan")).perform(click())
    }

    @Test
    fun checkMenuBacaKata() {
        Thread.sleep(4000)
        onView(withId(R.id.rv_list_student))
            .perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(0))
            .perform(
                RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                    0,
                    click()
                )
            )
        onView(withId(R.id.btn_select_student)).perform(click())
        Thread.sleep(2000)
        onView(withId(R.id.btn_baca_kata)).perform(click())
        Thread.sleep(2000)
    }

    @Test
    fun testBelajarVokal() {
        checkMenuBacaKata()
        onView(withId(R.id.btn_vokal))
            .perform(click())
        Thread.sleep(3000)
        onView(ViewMatchers.withText("Lanjutkan")).perform(click())
        Thread.sleep(3000)
        onView(ViewMatchers.withText("Lanjutkan")).perform(click())
        Thread.sleep(3000)
        onView(ViewMatchers.withText("Lanjutkan")).perform(click())
        Thread.sleep(3000)
        onView(ViewMatchers.withText("Lanjutkan")).perform(click())
        Thread.sleep(3000)
        onView(ViewMatchers.withText("Lanjutkan")).perform(click())
        Thread.sleep(3000)
    }

    @Test
    fun checkMenuBelajarSukuKata() {
        checkMenuBacaKata()
        onView(withId(R.id.btn_suku_kata))
            .perform(click())
        Thread.sleep(3000)
    }

    @Test
    fun testMateriBelajarSukuKata() {
        checkMenuBelajarSukuKata()
        onView(withText("b")).perform(click())
        Thread.sleep(3000)
        onView(withId(R.id.opta)).perform(click())
        Thread.sleep(3000)
        onView(withId(R.id.opti)).perform(click())
        Thread.sleep(3000)
        onView(withId(R.id.optu)).perform(click())
        Thread.sleep(3000)
        onView(withId(R.id.opte)).perform(click())
        Thread.sleep(3000)
        onView(withId(R.id.opto)).perform(click())
        Thread.sleep(3000)
    }

    @Test
    fun testSoalSusunKata() {
        checkMenuBacaKata()
        onView(withId(R.id.btn_latihan_suku_kata))
            .perform(click())
        Thread.sleep(3000)
        onView(withId(R.id.rv_susun_kata))
            .perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(0))
            .perform(
                RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                    0,
                    click()
                )
            )
        Thread.sleep(3000)
    }

    @Test
    fun testSoalBacaKata() {
        checkMenuBacaKata()
        onView(withId(R.id.btn_latihan_suku_kata))
            .perform(click())
        Thread.sleep(3000)
        onView(withId(R.id.rv_baca_kata))
            .perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(0))
            .perform(
                RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                    0,
                    click()
                )
            )
        Thread.sleep(3000)
    }

    @Test
    fun checkMenuLatihanBacaKalimat() {
        Thread.sleep(4000)
        onView(withId(R.id.rv_list_student))
            .perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(0))
            .perform(
                RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                    0,
                    click()
                )
            )
        onView(withId(R.id.btn_select_student)).perform(click())
        Thread.sleep(2000)
        onView(withId(R.id.btn_baca_kalimat)).perform(click())
        Thread.sleep(2000)
    }

    @Test
    fun testSoalSusunKalimat() {
        checkMenuLatihanBacaKalimat()
        onView(withId(R.id.rv_susun_kata))
            .perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(0))
            .perform(
                RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                    0,
                    click()
                )
            )
        Thread.sleep(3000)
    }

    @Test
    fun testSoalBacaKalimat() {
        checkMenuLatihanBacaKalimat()
        onView(withId(R.id.rv_baca_kata))
            .perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(0))
            .perform(
                RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                    0,
                    click()
                )
            )
        Thread.sleep(3000)
    }
}