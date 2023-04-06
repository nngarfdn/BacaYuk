package com.android.bisabelajar.ui.feat_dashboard

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.bisabelajar.data.preferences.interfaces.DataStoreRepository
import com.android.bisabelajar.utils.EMAIL
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class MainViewModel(private val repository: DataStoreRepository) : ViewModel() {

    fun saveEmail(value: String) {
        viewModelScope.launch {
            repository.putString(EMAIL, value)
        }
    }

    fun getEmail(): String? = runBlocking {
        repository.getString(EMAIL)
    }


}