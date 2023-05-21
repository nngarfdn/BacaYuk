package com.nara.bacayuk.domain.usecase

import android.util.Log
import com.nara.bacayuk.data.model.Response
import com.nara.bacayuk.data.model.User
import com.nara.bacayuk.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow

class UserUseCase(private val userRepository: UserRepository) {
    fun getUserFromFirestore(id: String): Flow<Response<User>> {
        Log.d("UserUseCase", "getUserFromFirestore: called")
        return userRepository.getUserFromFirestore(id)
    }
    suspend fun addUpdateUserToFirestore(user: User) = userRepository.addUpdateUserToFirestore(user)
}