package com.nara.bacayuk.ui.feat_auth.register

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nara.bacayuk.data.model.Response
import com.nara.bacayuk.data.model.User
import com.nara.bacayuk.domain.usecase.AuthUseCase
import com.nara.bacayuk.domain.usecase.UserUseCase
import com.nara.bacayuk.utils.EMAIL
import com.nara.bacayuk.utils.FULL_NAME_USER
import com.nara.bacayuk.utils.UID
import kotlinx.coroutines.launch

class RegisterViewModel(
    private val authUseCase: AuthUseCase,
    private val userUseCase: UserUseCase
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

    fun addUserToFirestore(user: User) = viewModelScope.launch {
        userUseCase.addUpdateUserToFirestore(user)
    }





}