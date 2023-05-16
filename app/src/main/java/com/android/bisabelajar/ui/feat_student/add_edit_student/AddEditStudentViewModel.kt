package com.android.bisabelajar.ui.feat_student.add_edit_student

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.bisabelajar.data.model.Response
import com.android.bisabelajar.data.model.Student
import com.android.bisabelajar.data.model.User
import com.android.bisabelajar.data.preferences.DataStoreRepository
import com.android.bisabelajar.domain.usecase.StudentUseCase
import com.android.bisabelajar.utils.EMAIL
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class AddEditStudentViewModel(
    private val studentUseCase: StudentUseCase,
    private val dataStore: DataStoreRepository,
): ViewModel() {

    private val _students = MutableLiveData<Response<List<Student>>>()
    val students : LiveData<Response<List<Student>>> = _students

    private val _isSuccess = MutableLiveData<Response<Boolean>>()
    val isSuccess : MutableLiveData<Response<Boolean>> = _isSuccess



    fun addUserToFirestore(idUser: String,student: Student) = viewModelScope.launch {
        val result = studentUseCase.addUpdateStudentToFirestore(idUser,student)
        if (result){
            _isSuccess.postValue(Response.Success(result))
        } else {
            _isSuccess.postValue(Response.Error(null, "Galgal Menambahkan"))
        }

    }

    fun getUID(): String? = runBlocking {
        dataStore.getString(EMAIL)
    }

    fun getAllStudent(id: String){
        Log.d("AddEditStudentViewModel", "getUser: called")
        viewModelScope.launch {
            try {
                studentUseCase.getAllUserFromFirestore(id).collect {
                    Log.d("AddEditStudentViewModel", "getUser: success")
                    _students.value = it
                }
            } catch (e: Exception) {
                Log.d("AddEditStudentViewModel", "getUser: fail")
                e.printStackTrace()
            }
        }
    }

}