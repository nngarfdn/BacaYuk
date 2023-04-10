package com.android.bisabelajar.domain.repository

import com.android.bisabelajar.data.model.Response
import com.android.bisabelajar.data.model.User
import kotlinx.coroutines.flow.Flow

typealias UserResponse = Response<User>
typealias AddUserResponse = Response<Boolean>
typealias UpdateUserResponse = Response<Boolean>

interface UserRepository {

    fun getUserFromFirestore(): Flow<UserResponse>
    suspend fun addNewUserToFirestore(user: User): AddUserResponse
    suspend fun updateProfileToFirestore(user: User): UpdateUserResponse

}