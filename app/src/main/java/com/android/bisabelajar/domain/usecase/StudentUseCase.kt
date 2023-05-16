package com.android.bisabelajar.domain.usecase

import com.android.bisabelajar.data.model.Response
import com.android.bisabelajar.data.model.Student
import com.android.bisabelajar.domain.repository.StudentRepository
import kotlinx.coroutines.flow.Flow

class StudentUseCase(private val repository: StudentRepository) {

    fun getAllUserFromFirestore(id: String): Flow<Response<List<Student>>> =
        repository.getAllUserFromFirestore(id)
    suspend fun addUpdateStudentToFirestore(idUser: String,user: Student): Boolean =
        repository.addUpdateStudentToFirestore(idUser,user)

}