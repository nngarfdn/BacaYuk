package com.android.bisabelajar.domain.usecase

import android.util.Log
import com.android.bisabelajar.data.model.Response
import com.android.bisabelajar.data.model.User
import com.android.bisabelajar.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow

class UserUseCase(private val userRepository: UserRepository) {
    fun getUserFromFirestore(id: String): Flow<Response<User>> {
        Log.d("UserUseCase", "getUserFromFirestore: called")
        return userRepository.getUserFromFirestore(id)
    }
    suspend fun addUpdateUserToFirestore(user: User) = userRepository.addUpdateUserToFirestore(user)
}