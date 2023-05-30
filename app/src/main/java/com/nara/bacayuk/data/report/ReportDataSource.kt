package com.nara.bacayuk.data.report

import com.nara.bacayuk.data.model.*
import kotlinx.coroutines.flow.Flow

interface ReportDataSource {
    //huruf
    suspend fun createReportHurufDataSets(idUser: String,idStudent: String): Boolean
    suspend fun updateReportHuruf(idUser: String,idStudent: String,reportHuruf: ReportHuruf): Boolean
    fun getAllReportFromFirestore(idUser: String, idStudent: String): Flow<Response<List<ReportHuruf>>>

    //kata
    suspend fun createReportKataDataSets(idUser: String,idStudent: String): Boolean
    suspend fun updateReportKata(idUser: String,idStudent: String,reportHuruf: ReportKata): Boolean
    fun getAllReportKataFromFirestore(idUser: String, idStudent: String): Flow<Response<ReportKata>>
    fun getAllBelajarVokal(idUser: String, idStudent: String): Flow<Response<List<BelajarSuku>>>

}