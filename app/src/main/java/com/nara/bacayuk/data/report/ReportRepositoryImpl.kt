package com.nara.bacayuk.data.report

import com.nara.bacayuk.data.model.BelajarSuku
import com.nara.bacayuk.data.model.ReportHuruf
import com.nara.bacayuk.data.model.ReportKata
import com.nara.bacayuk.data.model.Response
import com.nara.bacayuk.domain.repository.ReportRepository
import kotlinx.coroutines.flow.Flow

class ReportRepositoryImpl(private val dataSource: ReportDataSource) :ReportRepository {
    override suspend fun createReportHurufDataSets(idUser: String, idStudent: String): Boolean {
        return dataSource.createReportHurufDataSets(idUser, idStudent)
    }

    override suspend fun updateReportHuruf(
        idUser: String,
        idStudent: String,
        reportHuruf: ReportHuruf
    ): Boolean {
        return dataSource.updateReportHuruf(idUser, idStudent, reportHuruf)
    }

    override fun getAllReportFromFirestore(
        idUser: String,
        idStudent: String
    ): Flow<Response<List<ReportHuruf>>> {
        return dataSource.getAllReportFromFirestore(idUser, idStudent)
    }

    override suspend fun createReportKataDataSets(
        idUser: String,
        idStudent: String
    ): Boolean {
        return dataSource.createReportKataDataSets(idUser, idStudent)
    }

    override suspend fun updateReportKata(
        idUser: String,
        idStudent: String,
        reportHuruf: ReportKata
    ): Boolean {
        return dataSource.updateReportKata(idUser, idStudent, reportHuruf)
    }

    override fun getAllReportKataFromFirestore(
        idUser: String,
        idStudent: String
    ): Flow<Response<ReportKata>> {
        return dataSource.getAllReportKataFromFirestore(idUser, idStudent)
    }

    override fun getAllBelajarVokal(
        idUser: String,
        idStudent: String
    ): Flow<Response<List<BelajarSuku>>> {
        return dataSource.getAllBelajarVokal(idUser, idStudent)
    }
}