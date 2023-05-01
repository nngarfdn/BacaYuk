package com.android.bisabelajar.di

import com.android.bisabelajar.ui.feat_auth.login.LoginViewModel
import com.android.bisabelajar.ui.feat_dashboard.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.scope.get
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { MainViewModel(get(), get(), get()) }
    viewModel { LoginViewModel(get()) }
}