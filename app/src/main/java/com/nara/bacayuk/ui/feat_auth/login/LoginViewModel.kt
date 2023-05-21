package com.nara.bacayuk.ui.feat_auth.login

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nara.bacayuk.data.model.Response
import com.nara.bacayuk.data.model.User
import com.nara.bacayuk.data.preferences.DataStoreRepository
import com.nara.bacayuk.domain.usecase.AuthUseCase
import com.nara.bacayuk.utils.EMAIL
import com.nara.bacayuk.utils.FULL_NAME_USER
import com.nara.bacayuk.utils.UID
import com.nara.bacayuk.utils.USER
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