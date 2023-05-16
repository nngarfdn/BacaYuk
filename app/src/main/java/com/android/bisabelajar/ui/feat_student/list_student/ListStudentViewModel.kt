package com.android.bisabelajar.ui.feat_student.list_student

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.bisabelajar.data.model.Response
import com.android.bisabelajar.data.model.Student
import com.android.bisabelajar.data.model.User
import com.android.bisabelajar.data.preferences.DataStoreRepository
import com.android.bisabelajar.domain.usecase.AuthUseCase
import com.android.bisabelajar.domain.usecase.StudentUseCase
import com.android.bisabelajar.utils.EMAIL
import com.android.bisabelajar.utils.FULL_NAME_USER
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class ListStudentViewModel(
    private val dataStoreRepository: DataStoreRepository,
    private val authUseCase: AuthUseCase,
    private val studentUseCase: StudentUseCase,
    ): ViewModel() {

    private val _students = MutableLiveData<Response<List<Student>>>()
    val students: LiveData<Response<List<Student>>> = _students

    private val _isSuccess = MutableLiveData<Response<Boolean>>()
    val isSuccess : MutableLiveData<Response<Boolean>> = _isSuccess

    fun deleteStudentFirestore(idUser: String,idStudent: String) = viewModelScope.launch {
        val result = studentUseCase.deleteStudentFromFirestore(idUser,idStudent)
        if (result){
            _isSuccess.postValue(Response.Success(result))
        } else {
            _isSuccess.postValue(Response.Error(null, "Galgal Menambahkan"))
        }
    }

    fun logOutUser() = viewModelScope.launch {
        authUseCase.logOut()
        dataStoreRepository.clear()
    }

    fun getAllStudent(id: String){
        viewModelScope.launch {
            try {
                studentUseCase.getAllUserFromFirestore(id).collect {
                    Log.d("ListStudentViewModel", "getUser: success")
                    _students.value = it
                }
            } catch (e: Exception) {
                Log.d("ListStudentViewModel", "getUser: fail")
                e.printStackTrace()
            }
        }
    }


    fun getEmail(): String? = runBlocking {
        dataStoreRepository.getString(EMAIL)
    }

    fun getUID(): String? = runBlocking {
        dataStoreRepository.getString(EMAIL)
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