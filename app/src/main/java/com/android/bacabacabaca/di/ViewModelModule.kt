package com.android.bacabacabaca.di

import com.android.bacabacabaca.ui.feat_dashboard.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { MainViewModel(get()) }
}