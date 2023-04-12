package com.android.bisabelajar.ui.feat_dashboard

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.bisabelajar.data.model.User
import com.android.bisabelajar.data.preferences.DataStoreRepository
import com.android.bisabelajar.domain.usecase.AuthUseCase
import com.android.bisabelajar.domain.usecase.UserUseCase
import com.android.bisabelajar.utils.EMAIL
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class MainViewModel(
    private val repository: DataStoreRepository,
    private val authUseCase: AuthUseCase,
    private val userUseCase: UserUseCase
    ) : ViewModel() {

    fun saveUser(user: User) = viewModelScope.launch {
        userUseCase.addUpdateUserToFirestore(user)
    }

    fun register(email: String, password: String) = viewModelScope.launch {
        authUseCase.register(email, password)
    }

    fun saveEmail(value: String) {
        viewModelScope.launch {
            repository.putString(EMAIL, value)
        }
    }

    fun getEmail(): String? = runBlocking {
        repository.getString(EMAIL)
    }


}