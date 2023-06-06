package com.nara.bacayuk.ui.feat_menu_utama

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nara.bacayuk.data.model.ReportKalimat
import com.nara.bacayuk.data.model.Response
import com.nara.bacayuk.data.model.Student
import com.nara.bacayuk.data.model.User
import com.nara.bacayuk.data.preferences.DataStoreRepository
import com.nara.bacayuk.domain.usecase.AuthUseCase
import com.nara.bacayuk.domain.usecase.ReportUseCase
import com.nara.bacayuk.domain.usecase.StudentUseCase
import com.nara.bacayuk.domain.usecase.UserUseCase
import com.nara.bacayuk.utils.EMAIL
import com.nara.bacayuk.utils.FULL_NAME_USER
import com.nara.bacayuk.utils.UID
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class MainViewModel(
    private val dataStoreRepository: DataStoreRepository,
    private val authUseCase: AuthUseCase,
    private val userUseCase: UserUseCase,
    private val reportUseCase: ReportUseCase,
    private val studentUseCase: StudentUseCase
    ) : ViewModel() {

    fun createReportHurufDataSets(
        isFirstOpen: Boolean,
        idUser: String,
        idStudent: String,
        student: Student
    ) =
        viewModelScope.launch {
            val user = getUserDataStore()
            try {
                if (isFirstOpen) {
                    student.isReadyHurufDataSet = true
                    user?.let {
                        val changedStudent = student
                        changedStudent.isReadyHurufDataSet = true
                        studentUseCase.addUpdateStudentToFirestore(it.uuid ?: "-", changedStudent) }
                    val status = reportUseCase.createReportHurufDataSets(idUser, idStudent)
                    val statusKata = reportUseCase.createReportKataDataSets(idUser, idStudent)
                    val statusKalimat = reportUseCase.addUpdateReportKalimat(idUser, idStudent, ReportKalimat())
                    if (status) Log.d("createReport", "Report Huruf data set created")
                    else Log.d("createReport", "Report Huruf data set creation failed")
                    if (statusKata) Log.d("createReport", "Report Kata data set created")
                    else Log.d("createReport", "Report Kata data set creation failed")
                    if (statusKalimat) Log.d("createReport", "Report Kata data set created")
                    else Log.d("createReport", "Report Kata data set creation failed")
                }
            } catch (e: Exception) {
                Log.d("MainViewModel", "login: fail")
                e.printStackTrace()
            }
        }

    private val _user = MutableLiveData<Response<User>>()
    val user: LiveData<Response<User>> = _user

    fun saveUser(user: User) = viewModelScope.launch {
        userUseCase.addUpdateUserToFirestore(user)
    }

    fun logOutUser() = viewModelScope.launch {
        authUseCase.logOut()
        dataStoreRepository.clear()
    }

    fun getUser(id: String){
        Log.d("MainViewModel", "getUser: called")
        viewModelScope.launch {
            try {
                userUseCase.getUserFromFirestore(id).collect {
                    Log.d("MainViewModel", "getUser: success")
                    _user.value = it
                }
            } catch (e: Exception) {
                Log.d("MainViewModel", "getUser: fail")
                e.printStackTrace()
            }
        }
    }

    fun register(email: String, password: String) = viewModelScope.launch {
        authUseCase.register(email, password)
    }

    fun getEmail(): String? = runBlocking {
        dataStoreRepository.getString(EMAIL)
    }

    fun getUID(): String? = runBlocking {
        dataStoreRepository.getString(UID)
    }

    fun getFullName(): String? = runBlocking {
        dataStoreRepository.getString(FULL_NAME_USER)
    }


    fun getUserDataStore(): User? {
        val uid = getUID()
        val email = getEmail()
        val fullName = getFullName()
        return if (uid!= null && email!= null && fullName!= null) {
            User(uid, email, fullName)
        } else {
            null
        }
    }


}