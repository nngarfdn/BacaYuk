package com.nara.bacayuk.data.preferences.implementation

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.nara.bacayuk.data.preferences.DataStoreRepository
import com.nara.bacayuk.data.preferences.DataStoreRepositoryImpl
import com.nara.bacayuk.data.preferences.dataStore
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class DataStoreRepositoryImplTest{

    lateinit var dataStoreRepository: DataStoreRepository
    lateinit var dataStore: DataStore<*>
    lateinit var context: Context

    @Before
    fun setUp() = runBlocking {
        context = ApplicationProvider.getApplicationContext<Context>()
        dataStoreRepository = DataStoreRepositoryImpl(context)
        dataStore = dataStoreRepository.getDataStore()
    }

    @Test
    fun testPutString() = runBlocking {
        val key = "string_key"
        val value = "string_value"
        dataStoreRepository.putString(key, value)
        val preferencesKey = stringPreferencesKey(key)
        val preferences = context.dataStore.data.first()
        val result = preferences[preferencesKey]
        assertEquals(value, result)
    }

    @Test
    fun testGetString() = runBlocking {
        val key = "string_key"
        val value = "string_value"
        dataStoreRepository.putString(key, value)
        val result = dataStoreRepository.getString(key)
        assertEquals(value, result)
    }

    @Test
    fun testPutInt() = runBlocking {
        val key = "int_key"
        val value = 1
        dataStoreRepository.putInt(key, value)
        val preferencesKey = intPreferencesKey(key)
        val preferences = context.dataStore.data.first()
        val result = preferences[preferencesKey]?.toInt() ?: 0
        assertEquals(value, result)
    }


    @Test
    fun testGetInt() = runBlocking {
        val key = "int_key"
        val value = 1
        dataStoreRepository.putInt(key, value)
        val result = dataStoreRepository.getInt(key)
        assertEquals(value, result)
    }

}