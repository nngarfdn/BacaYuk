package com.android.bacabacabaca

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.preference.Preference
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.android.bacabacabaca.data.preferences.abstraction.DataStoreRepository
import com.android.bacabacabaca.data.preferences.implementation.DataStoreRepositoryImpl
import com.android.bacabacabaca.data.preferences.implementation.dataStore
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
//@RunWith(AndroidJUnit4::class)
class ExampleUnitTest {

    @Mock
    lateinit var dataStoreRepository: DataStoreRepository

    @Mock
    lateinit var dataStore: DataStore<*>

    @Mock
    lateinit var context: Context

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
    }

    @Test
    fun testPutString() = runBlocking {
        val key = "string_key"
        val value = "string_value"
        val preferencesKey = stringPreferencesKey(key)
//        val preferences = mock(DataStore.Preference::class.java)
        val preferences = mock(Preferences::class.java)
        //context
        `when`(ApplicationProvider.getApplicationContext<Context>()).thenReturn(context)
        `when`(dataStoreRepository.getDataStore()).thenReturn(dataStore)
        `when`(dataStore.data.first()).thenReturn(preferences)
        `when`(preferences[preferencesKey]).thenReturn(value)
        //dataStoreRepository
        dataStoreRepository.putString(key, value)
        verify(dataStoreRepository).putString(key, value)
    }

    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }


}