package com.android.bisabelajar.domain.repository

import com.android.bisabelajar.data.model.Response
import com.android.bisabelajar.data.model.Student
import kotlinx.coroutines.flow.Flow

interface StudentRepository {
    fun getAllUserFromFirestore(id: String): Flow<Response<List<Student>>>
    suspend fun addUpdateStudentToFirestore(idUser: String,user: Student): Boolean
}