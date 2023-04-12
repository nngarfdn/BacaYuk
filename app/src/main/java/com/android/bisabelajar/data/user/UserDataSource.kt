package com.android.bisabelajar.data.user

import com.android.bisabelajar.data.model.Response
import com.android.bisabelajar.data.model.User
import kotlinx.coroutines.flow.Flow

interface UserDataSource {
    fun getUserFromFirestore(id: String): Flow<Response<User>>
    suspend fun addUpdateUserToFirestore(user: User): Boolean
}

//Flow tidak diperlukan karena fungsi ini hanya melakukan operasi I/O tunggal dan mengembalikan satu nilai boolean.