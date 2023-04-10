package com.android.bisabelajar.data.user

import com.android.bisabelajar.data.model.User
import com.android.bisabelajar.domain.repository.AddUserResponse
import com.android.bisabelajar.domain.repository.UpdateUserResponse
import com.android.bisabelajar.domain.repository.UserRepository
import com.android.bisabelajar.domain.repository.UserResponse
import kotlinx.coroutines.flow.Flow

class UserRepositoryImpl(private val reference: UserDataSource) : UserRepository {
    override fun getUserFromFirestore(): Flow<UserResponse> {
        TODO("Not yet implemented")
    }

    override suspend fun addNewUserToFirestore(user: User): AddUserResponse {
        TODO("Not yet implemented")
    }

    override suspend fun updateProfileToFirestore(user: User): UpdateUserResponse {
        TODO("Not yet implemented")
    }

}