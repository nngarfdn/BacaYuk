package com.android.bisabelajar.domain.usecase

import com.android.bisabelajar.domain.repository.AuthRepository

class AuthUseCase(private val authRepository: AuthRepository) {
    suspend fun login(email: String, password: String) = authRepository.login(email, password)
    suspend fun register(email: String, password: String) = authRepository.register(email, password)
}