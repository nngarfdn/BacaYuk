package com.android.bisabelajar.di

import com.android.bisabelajar.ui.feat_auth.forgot_password.ForgotPasswordViewModel
import com.android.bisabelajar.ui.feat_auth.login.LoginViewModel
import com.android.bisabelajar.ui.feat_auth.register.RegisterViewModel
import com.android.bisabelajar.ui.feat_menu_utama.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { MainViewModel(get(), get(), get()) }
    viewModel { LoginViewModel(get()) }
    viewModel { RegisterViewModel(get())}
    viewModel { ForgotPasswordViewModel(get())}
}