package com.android.bisabelajar.ui.feat_auth.register

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.bisabelajar.data.model.Response
import com.android.bisabelajar.data.model.User
import com.android.bisabelajar.domain.usecase.AuthUseCase
import kotlinx.coroutines.launch

class RegisterViewModel(
    private val authUseCase: AuthUseCase,
) : ViewModel(){

    private val _user = MutableLiveData<Response<User>>()
    val user: LiveData<Response<User>> = _user

    private val _errorMessage = MutableLiveData<String>()
    val errorMessage: LiveData<String> = _errorMessage

    fun register(email: String, password: String) = viewModelScope.launch {
        try {
            authUseCase.register(email, password).collect {
                Log.d("MainViewModel", "login: success")
                _user.value = it
            }
        } catch (e: Exception) {
            Log.d("MainViewModel", "login: fail")
            _errorMessage.value = e.message
            e.printStackTrace()
        }
    }

}