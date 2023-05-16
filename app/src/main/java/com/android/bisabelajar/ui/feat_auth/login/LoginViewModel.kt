package com.android.bisabelajar.ui.feat_auth.login

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.bisabelajar.data.model.Response
import com.android.bisabelajar.data.model.User
import com.android.bisabelajar.data.preferences.DataStoreRepository
import com.android.bisabelajar.domain.usecase.AuthUseCase
import com.android.bisabelajar.utils.EMAIL
import com.android.bisabelajar.utils.FULL_NAME_USER
import com.android.bisabelajar.utils.UID
import com.android.bisabelajar.utils.USER
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class LoginViewModel(
    private val dataStore: DataStoreRepository,
    private val authUseCase: AuthUseCase,
) : ViewModel() {

    private val _user = MutableLiveData<Response<User>>()
    val user: LiveData<Response<User>> = _user

    private val _userDataStore = MutableLiveData<User?>()
    val userDataStore: LiveData<User?> = _userDataStore

    private val _errorMessage = MutableLiveData<String>()
    val errorMessage: LiveData<String> = _errorMessage

    fun putUser(user: User) = viewModelScope.launch {
        try {
            dataStore.putUser(USER,user)
        } catch (e: Exception) {
            Log.d("MainViewModel", "login: fail")
            _errorMessage.value = e.message
            e.printStackTrace()
        }
    }

    fun saveUserToDataStore(data: User) {
        viewModelScope.launch {
            data.email?.let { dataStore.putString(EMAIL, it) }
            data.uuid?.let { dataStore.putString(UID, it) }
            data.fullName?.let { dataStore.putString(FULL_NAME_USER, it) }
        }
    }

    fun getEmail(): String? = runBlocking {
        dataStore.getString(EMAIL)
    }

    fun getUID(): String? = runBlocking {
        dataStore.getString(EMAIL)
    }

    fun getFullName(): String? = runBlocking {
        dataStore.getString(FULL_NAME_USER)
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


    fun login(email: String, password: String) = viewModelScope.launch {
        try {
            authUseCase.login(email, password).collect {
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