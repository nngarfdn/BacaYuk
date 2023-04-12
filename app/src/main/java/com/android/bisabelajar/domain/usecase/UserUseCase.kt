package com.android.bisabelajar.domain.usecase

import com.android.bisabelajar.data.model.User
import com.android.bisabelajar.domain.repository.UserRepository

class UserUseCase(private val userRepository: UserRepository) {
    fun getUserFromFirestore(id: String) = userRepository.getUserFromFirestore(id)
    suspend fun addUpdateUserToFirestore(user: User) = userRepository.addUpdateUserToFirestore(user)
}