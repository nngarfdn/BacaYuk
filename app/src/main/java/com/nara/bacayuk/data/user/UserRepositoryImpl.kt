package com.nara.bacayuk.data.user

import android.util.Log
import com.nara.bacayuk.data.model.Response
import com.nara.bacayuk.data.model.User
import com.nara.bacayuk.domain.repository.UserRepository
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