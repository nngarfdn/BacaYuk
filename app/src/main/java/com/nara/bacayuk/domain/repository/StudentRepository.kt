package com.nara.bacayuk.domain.repository

import com.nara.bacayuk.data.model.Response
import com.nara.bacayuk.data.model.Student
import kotlinx.coroutines.flow.Flow

interface StudentRepository {
    fun getAllUserFromFirestore(id: String): Flow<Response<List<Student>>>
    suspend fun addUpdateStudentToFirestore(idUser: String,user: Student): Boolean
    suspend fun deleteStudentFromFirestore(idUser: String,idStudent: String): Boolean
}