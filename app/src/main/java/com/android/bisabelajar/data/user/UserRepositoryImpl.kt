package com.android.bisabelajar.data.user

import android.util.Log
import com.android.bisabelajar.data.model.Response
import com.android.bisabelajar.data.model.User
import com.android.bisabelajar.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow

class UserRepositoryImpl(private val dataSource: UserDataSource) : UserRepository {

    override fun getUserFromFirestore(id: String): Flow<Response<User>> {
        Log.d("UserRepositoryImpl", "getUserFromFirestore: called")
        return dataSource.getUserFromFirestore(id)
    }

    override suspend fun addUpdateUserToFirestore(user: User): Boolean {
        return dataSource.addUpdateUserToFirestore(user)
    }
}