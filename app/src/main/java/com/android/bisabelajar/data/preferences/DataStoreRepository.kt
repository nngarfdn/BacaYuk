package com.android.bisabelajar.data.preferences

import androidx.datastore.core.DataStore
import com.android.bisabelajar.data.model.User

interface DataStoreRepository {
    fun getDataStore(): DataStore<*>
    suspend fun putString(key: String, value: String)
    suspend fun putInt(key: String, value: Int)
    suspend fun getString(key: String): String?
    suspend fun getInt(key: String): Int?
    suspend fun clear()

    suspend fun putUser(key: String, student: User)
    suspend fun getUser(): User?

}