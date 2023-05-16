package com.android.bisabelajar.data.student

import android.util.Log
import com.android.bisabelajar.data.model.Response
import com.android.bisabelajar.data.model.Student
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.tasks.await


class StudentDataSourceImpl: StudentDataSource {
    override fun getAllUserFromFirestore(id: String): Flow<Response<List<Student>>> {
        return flow {
            val firestoreInstance = FirebaseFirestore.getInstance()
            val students = mutableListOf<Student>()
            val snapshot = firestoreInstance.collection("Users")
                .document(id).collection("Students").get().await()
            //get list students

            for (doc in snapshot.documents) {
                doc.toObject(Student::class.java)?.let { students.add(it) }
            }
            emit(Response.Success(students))
        }.catch {
//            emit(Response.Error(null,"Failed to fetch user data from Firestore."))

            Log.e("getAllUserFromFirestore", "Failed to fetch user data from Firestore.", it)
        }
    }

    override suspend fun addUpdateStudentToFirestore(idUser:String, student: Student): Boolean {
        return try {
            val firestoreInstance = FirebaseFirestore.getInstance()
            val documentReference =
                firestoreInstance.collection("Users").document(idUser)
                    .collection("Students").document(student.uuid)

            documentReference.set(student).await()
            true // kembalikan nilai boolean true jika operasi berhasil
        } catch (e: Exception) {
            Log.e("UserDataSourceImpl", "Error adding or updating user to Firestore.", e)
            false // kembalikan nilai boolean false jika operasi gagal
        }
    }

    override suspend fun deleteStudentFromFirestore(idUser: String, idStudent: String): Boolean {
        return try {
            val firestoreInstance = FirebaseFirestore.getInstance()
            val documentReference = firestoreInstance.collection("Users").document(idUser)
                .collection("Students").document(idStudent)
            documentReference.delete().await()
            true
        }  catch (e: Exception) {
            Log.e("UserDataSourceImpl", "Error Delete", e)
            false // kembalikan nilai boolean false jika operasi gagal
        }
    }
}

