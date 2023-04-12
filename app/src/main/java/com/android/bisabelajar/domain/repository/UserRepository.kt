package com.android.bisabelajar.domain.repository

import com.android.bisabelajar.data.model.Response
import com.android.bisabelajar.data.model.User
import kotlinx.coroutines.flow.Flow

interface UserRepository {

    fun getUserFromFirestore(id: String): Flow<Response<User>>
    suspend fun addUpdateUserToFirestore(user: User): Boolean

}