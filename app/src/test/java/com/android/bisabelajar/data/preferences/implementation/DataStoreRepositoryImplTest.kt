package com.android.bisabelajar.data.preferences.implementation

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.test.core.app.ApplicationProvider
import com.android.bisabelajar.data.preferences.interfaces.DataStoreRepository
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test


class DataStoreRepositoryImplTest {

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
//        val result = dataStore.data.map[preferencesKey<String>(key)] as String?
        val preferencesKey = stringPreferencesKey(key)
        val preferences = context.dataStore.data.first()
        val result = preferences[preferencesKey]
        assertEquals(value, result)
    }

    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }



}