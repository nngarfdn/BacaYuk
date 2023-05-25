package com.nara.bacayuk.data.report

import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore
import com.nara.bacayuk.data.model.ReportHuruf
import com.nara.bacayuk.data.model.Response
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.tasks.await

class ReportDataSourceImpl: ReportDataSource {

    override suspend fun updateReportHuruf(idUser: String,idStudent: String,reportHuruf: ReportHuruf): Boolean {
        return try {
            val firestoreInstance = FirebaseFirestore.getInstance()
            val snapshot = firestoreInstance.collection("Users")
                .document(idUser).collection("Students").document(idStudent)
                .collection("ReportHuruf").document(reportHuruf.abjadName).set(reportHuruf).await()
            true // kembalikan nilai boolean true jika operasi berhasil
        } catch (e: Exception) {
            Log.e("UserDataSourceImpl", "Error adding or updating user to Firestore.", e)
            false // kembalikan nilai boolean false jika operasi gagal
        }
    }

    override fun getAllReportFromFirestore(
        idUser: String,
        idStudent: String
    ): Flow<Response<List<ReportHuruf>>> {
        return flow {
            val firestoreInstance = FirebaseFirestore.getInstance()
            val students = mutableListOf<ReportHuruf>()
            val snapshot = firestoreInstance.collection("Users")
                .document(idUser).collection("Students").document(idStudent)
                .collection("ReportHuruf").get().await()
            //get list students
            for (doc in snapshot.documents) {
                doc.toObject(ReportHuruf::class.java)?.let { students.add(it) }
            }
            emit(Response.Success(students))
        }.catch {
            Log.e("getAllUserFromFirestore", "Failed to fetch user data from Firestore.", it)
        }
    }

    override suspend fun createReportHurufDataSets(idUser: String,idStudent: String): Boolean {
        return try {
            val datasets = createDataSet()
            val firestoreInstance = FirebaseFirestore.getInstance()
            for (item in datasets) {
                val documentReference =
                    firestoreInstance.collection("Users").document(idUser)
                        .collection("Students").document(idStudent)
                        .collection("ReportHuruf").document(item.abjadName)

                documentReference.set(item).await()
            }

            true // kembalikan nilai boolean true jika operasi berhasil
        } catch (e: Exception) {
            Log.e("UserDataSourceImpl", "Error adding or updating user to Firestore.", e)
            false // kembalikan nilai boolean false jika operasi gagal
        }
    }


    private fun createDataSet(): List<ReportHuruf>{
        val reportHurufs = mutableListOf<ReportHuruf>()
        for (i in 65..90) {
            val huruf = i.toChar().toString() + i.toChar().toLowerCase().toString()
            val reportHuruf = ReportHuruf(abjadName = huruf)
            reportHurufs.add(reportHuruf)
        }
        return reportHurufs
    }
}