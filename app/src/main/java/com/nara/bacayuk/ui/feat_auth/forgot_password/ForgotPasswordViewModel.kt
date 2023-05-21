package com.nara.bacayuk.ui.feat_auth.forgot_password

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nara.bacayuk.domain.usecase.AuthUseCase
import kotlinx.coroutines.launch

class ForgotPasswordViewModel(private val authUseCase: AuthUseCase): ViewModel(){

    fun forgotPassword(email: String) = viewModelScope.launch {
        authUseCase.forgotPassword(email)
    }

}