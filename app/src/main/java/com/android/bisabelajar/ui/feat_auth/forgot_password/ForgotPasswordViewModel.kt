package com.android.bisabelajar.ui.feat_auth.forgot_password

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.bisabelajar.domain.usecase.AuthUseCase
import kotlinx.coroutines.launch

class ForgotPasswordViewModel(private val authUseCase: AuthUseCase): ViewModel(){

    fun forgotPassword(email: String) = viewModelScope.launch {
        authUseCase.forgotPassword(email)
    }

}