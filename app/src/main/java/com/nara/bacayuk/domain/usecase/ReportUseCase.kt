package com.nara.bacayuk.domain.usecase

import com.nara.bacayuk.data.model.*
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

    suspend fun createReportKataDataSets(
        idUser: String,
        idStudent: String
    ): Boolean = repository.createReportKataDataSets(idUser, idStudent)

    suspend fun updateReportKata(
        idUser: String,
        idStudent: String,
        reportHuruf: ReportKata
    ): Boolean = repository.updateReportKata(idUser, idStudent, reportHuruf)

    fun getAllReportKataFromFirestore(
        idUser: String,
        idStudent: String
    ): Flow<Response<ReportKata>> = repository.getAllReportKataFromFirestore(idUser, idStudent)

    fun getAllBelajarVokal(idUser: String, idStudent: String): Flow<Response<List<BelajarSuku>>>
    = repository.getAllBelajarVokal(idUser, idStudent)

    suspend fun addUpdateReportKalimat(idUser: String,idStudent: String,reportHuruf: ReportKalimat): Boolean
    = repository.addUpdateReportKalimat(idUser, idStudent, reportHuruf)
    fun getAllReportKalimatFromFirestore(idUser: String, idStudent: String): Flow<Response<ReportKalimat>>
    = repository.getAllReportKalimatFromFirestore(idUser, idStudent)

    suspend fun updateBelajarSuku(idUser: String,idStudent: String,reportHuruf: BelajarSuku): Boolean
    = repository.updateBelajarSuku(idUser, idStudent, reportHuruf)
}