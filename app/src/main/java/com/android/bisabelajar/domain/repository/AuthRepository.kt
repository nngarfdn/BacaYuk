package com.android.bisabelajar.domain.repository

import com.android.bisabelajar.data.model.Response
import com.android.bisabelajar.data.model.User
import kotlinx.coroutines.flow.Flow

typealias LoginResponse = Response<User>
typealias RegisterResponse = Response<User>

interface AuthRepository {
    suspend fun register(email: String, password: String): LoginResponse
    suspend fun login(email: String, password: String): RegisterResponse
}