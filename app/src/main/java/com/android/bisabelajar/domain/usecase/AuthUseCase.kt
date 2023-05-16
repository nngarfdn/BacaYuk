package com.android.bisabelajar.domain.usecase

import com.android.bisabelajar.data.model.Response
import com.android.bisabelajar.domain.repository.AuthRepository
import com.android.bisabelajar.domain.repository.LoginResponse
import com.android.bisabelajar.domain.repository.RegisterResponse
import kotlinx.coroutines.flow.Flow

class AuthUseCase(private val authRepository: AuthRepository) {
    suspend fun login(email: String, password: String): Flow<LoginResponse> = authRepository.login(email, password)
    suspend fun register(email: String, password: String): Flow<RegisterResponse> = authRepository.register(email, password)
    suspend fun forgotPassword(email: String) = authRepository.forgotPassword(email)
    suspend fun logOut() = authRepository.logOut()
}