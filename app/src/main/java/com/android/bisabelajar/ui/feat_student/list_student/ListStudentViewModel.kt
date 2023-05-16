package com.android.bisabelajar.ui.feat_student.list_student

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.bisabelajar.data.model.User
import com.android.bisabelajar.data.preferences.DataStoreRepository
import com.android.bisabelajar.domain.usecase.AuthUseCase
import com.android.bisabelajar.utils.EMAIL
import com.android.bisabelajar.utils.FULL_NAME_USER
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class ListStudentViewModel(
    private val dataStoreRepository: DataStoreRepository,
    private val authUseCase: AuthUseCase
    ): ViewModel() {


    fun logOutUser() = viewModelScope.launch {
        authUseCase.logOut()
        dataStoreRepository.clear()
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