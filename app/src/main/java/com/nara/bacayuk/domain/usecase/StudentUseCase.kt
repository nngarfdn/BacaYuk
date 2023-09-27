package com.nara.bacayuk.domain.usecase

import com.nara.bacayuk.data.model.Response
import com.nara.bacayuk.data.model.Student
import com.nara.bacayuk.domain.repository.StudentRepository
import kotlinx.coroutines.flow.Flow

class StudentUseCase(private val repository: StudentRepository) {

    fun getAllUserFromFirestore(id: String): Flow<Response<List<Student>>> =
        repository.getAllUserFromFirestore(id)
    suspend fun addUpdateStudentToFirestore(idUser: String,user: Student): Boolean =
        repository.addUpdateStudentToFirestore(idUser,user)
    suspend fun deleteStudentFromFirestore(id: String, idStudent: String): Boolean =
        repository.deleteStudentFromFirestore(id,idStudent)

}