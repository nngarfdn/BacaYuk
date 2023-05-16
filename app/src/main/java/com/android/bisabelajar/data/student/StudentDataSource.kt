package com.android.bisabelajar.data.student

import com.android.bisabelajar.data.model.Response
import com.android.bisabelajar.data.model.Student
import com.android.bisabelajar.data.model.User
import kotlinx.coroutines.flow.Flow

interface StudentDataSource {
    fun getAllUserFromFirestore(id: String): Flow<Response<List<Student>>>
    suspend fun addUpdateStudentToFirestore(idUser: String,user: Student): Boolean
    suspend fun deleteStudentFromFirestore(idUser: String,idStudent: String): Boolean
}