package com.android.bisabelajar.data.student

import com.android.bisabelajar.data.model.Response
import com.android.bisabelajar.data.model.Student
import com.android.bisabelajar.domain.repository.StudentRepository
import kotlinx.coroutines.flow.Flow

class StudentRepositoryImpl(private val studentDataSource: StudentDataSource): StudentRepository {
    override fun getAllUserFromFirestore(id: String): Flow<Response<List<Student>>> {
        return studentDataSource.getAllUserFromFirestore(id)
    }

    override suspend fun addUpdateStudentToFirestore(idUser: String, user: Student): Boolean {
        return studentDataSource.addUpdateStudentToFirestore(idUser, user)
    }
}