package com.android.bacabacabaca.ui.feat_dashboard

import android.content.Context
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.android.bacabacabaca.data.preferences.implementation.DataStoreRepositoryImpl
import org.junit.Assert.*

import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainViewModelTest {

    private val context = androidx.test.core.app.ApplicationProvider.getApplicationContext<Context>()
    private val repository = DataStoreRepositoryImpl(context)
    private val viewModel = MainViewModel(repository)

    @Test
    fun saveEmail() {
        val email = "nan@gmail.com"
        val result = "nan@gmail.com"
        assertEquals(email, result)
    }

    @Test
    fun getEmail() {
    }
}