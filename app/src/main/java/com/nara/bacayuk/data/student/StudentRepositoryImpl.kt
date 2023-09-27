package com.nara.bacayuk.data.student

import com.nara.bacayuk.data.model.Response
import com.nara.bacayuk.data.model.Student
import com.nara.bacayuk.domain.repository.StudentRepository
import kotlinx.coroutines.flow.Flow

class StudentRepositoryImpl(private val studentDataSource: StudentDataSource): StudentRepository {
    override fun getAllUserFromFirestore(id: String): Flow<Response<List<Student>>> {
        return studentDataSource.getAllUserFromFirestore(id)
    }
    override suspend fun addUpdateStudentToFirestore(idUser: String, user: Student): Boolean {
        return studentDataSource.addUpdateStudentToFirestore(idUser, user)
    }
    override suspend fun deleteStudentFromFirestore(idUser: String, idStudent: String): Boolean {
        return studentDataSource.deleteStudentFromFirestore(idUser, idStudent)
    }
}