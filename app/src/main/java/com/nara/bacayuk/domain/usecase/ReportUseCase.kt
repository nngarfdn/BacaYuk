package com.nara.bacayuk.domain.usecase

import com.nara.bacayuk.data.model.ReportHuruf
import com.nara.bacayuk.data.model.Response
import com.nara.bacayuk.domain.repository.ReportRepository
import kotlinx.coroutines.flow.Flow

class ReportUseCase(private val repository: ReportRepository) {
    suspend fun createReportHurufDataSets(idUser: String, idStudent: String): Boolean =
        repository.createReportHurufDataSets(idUser, idStudent)

    suspend fun updateReportHuruf(
        idUser: String,
        idStudent: String,
        reportHuruf: ReportHuruf
    ): Boolean = repository.updateReportHuruf(idUser, idStudent, reportHuruf)

    fun getAllReportFromFirestore(
        idUser: String,
        idStudent: String
    ): Flow<Response<List<ReportHuruf>>> = repository.getAllReportFromFirestore(idUser, idStudent)
}