package com.nara.bacayuk.data.report

import com.nara.bacayuk.data.model.ReportHuruf
import com.nara.bacayuk.data.model.Response
import kotlinx.coroutines.flow.Flow

interface ReportDataSource {
    suspend fun createReportHurufDataSets(idUser: String,idStudent: String): Boolean
    suspend fun updateReportHuruf(reportHuruf: ReportHuruf): Boolean
    fun getAllReportFromFirestore(idUser: String, idStudent: String): Flow<Response<List<ReportHuruf>>>
}