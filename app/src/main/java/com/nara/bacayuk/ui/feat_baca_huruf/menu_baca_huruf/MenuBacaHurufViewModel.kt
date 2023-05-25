package com.nara.bacayuk.ui.feat_baca_huruf.menu_baca_huruf

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nara.bacayuk.data.model.ReportHuruf
import com.nara.bacayuk.data.model.Response
import com.nara.bacayuk.data.model.Student
import com.nara.bacayuk.data.preferences.DataStoreRepository
import com.nara.bacayuk.domain.usecase.ReportUseCase
import com.nara.bacayuk.domain.usecase.UserUseCase
import com.nara.bacayuk.utils.UID
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class MenuBacaHurufViewModel(
    private val dataStoreRepository: DataStoreRepository,
    private val reportUseCase: ReportUseCase,
    private val userUseCase: UserUseCase
): ViewModel() {

    private val _reports = MutableLiveData<Response<List<ReportHuruf>>>()
    val reports: LiveData<Response<List<ReportHuruf>>> = _reports


    fun getAllReports(idStudent: String){
        viewModelScope.launch {
            try {
                reportUseCase.getAllReportFromFirestore(getUID() ?: "-", idStudent).collect {
                    Log.d("ListStudentViewModel", "getUser: success")
                    _reports.value = it
                }
            } catch (e: Exception) {
                Log.d("ListStudentViewModel", "getUser: fail")
                e.printStackTrace()
            }
        }
    }

    fun getUID(): String? = runBlocking {
        dataStoreRepository.getString(UID)
    }

}