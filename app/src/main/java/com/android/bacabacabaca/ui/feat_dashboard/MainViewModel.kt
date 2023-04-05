package com.android.bacabacabaca.ui.feat_dashboard

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.bacabacabaca.data.preferences.abstraction.DataStoreRepository
import com.android.bacabacabaca.utils.EMAIL
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