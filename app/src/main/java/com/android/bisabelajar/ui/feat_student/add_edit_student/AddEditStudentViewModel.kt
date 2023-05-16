package com.android.bisabelajar.ui.feat_student.add_edit_student

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.bisabelajar.data.model.Response
import com.android.bisabelajar.data.model.Student
import com.android.bisabelajar.data.model.User
import com.android.bisabelajar.domain.usecase.StudentUseCase
import kotlinx.coroutines.launch

class AddEditStudentViewModel(val studentUseCase: StudentUseCase): ViewModel() {

    private val _students = MutableLiveData<Response<List<Student>>>()
    val students : LiveData<Response<List<Student>>> = _students

    fun addUserToFirestore(idUser: String,student: Student) = viewModelScope.launch {
        studentUseCase.addUpdateStudentToFirestore(idUser, student)
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