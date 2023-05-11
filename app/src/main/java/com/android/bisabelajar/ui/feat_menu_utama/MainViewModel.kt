package com.android.bisabelajar.ui.feat_menu_utama

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.bisabelajar.data.model.Response
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

    private val _user = MutableLiveData<Response<User>>()
    val user: LiveData<Response<User>> = _user

    fun saveUser(user: User) = viewModelScope.launch {
        userUseCase.addUpdateUserToFirestore(user)
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

    fun saveEmail(value: String) {
        viewModelScope.launch {
            repository.putString(EMAIL, value)
        }
    }


    fun getEmail(): String? = runBlocking {
        repository.getString(EMAIL)
    }


}