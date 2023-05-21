package com.nara.bacayuk.domain.repository

import com.nara.bacayuk.data.model.Response
import com.nara.bacayuk.data.model.User
import kotlinx.coroutines.flow.Flow

interface UserRepository {

    fun getUserFromFirestore(id: String): Flow<Response<User>>
    suspend fun addUpdateUserToFirestore(user: User): Boolean

}