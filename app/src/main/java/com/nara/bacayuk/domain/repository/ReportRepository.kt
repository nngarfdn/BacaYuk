package com.nara.bacayuk.domain.repository

import com.nara.bacayuk.data.model.ReportHuruf
import com.nara.bacayuk.data.model.Response
import kotlinx.coroutines.flow.Flow

interface ReportRepository {
    suspend fun createReportHurufDataSets(idUser: String,idStudent: String): Boolean
    suspend fun updateReportHuruf(idUser: String,idStudent: String,reportHuruf: ReportHuruf): Boolean
    fun getAllReportFromFirestore(idUser: String, idStudent: String): Flow<Response<List<ReportHuruf>>>
}