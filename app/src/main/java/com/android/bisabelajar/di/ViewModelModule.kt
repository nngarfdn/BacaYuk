package com.android.bisabelajar.di

import com.android.bisabelajar.ui.feat_auth.forgot_password.ForgotPasswordViewModel
import com.android.bisabelajar.ui.feat_auth.login.LoginViewModel
import com.android.bisabelajar.ui.feat_auth.register.RegisterViewModel
import com.android.bisabelajar.ui.feat_menu_utama.MainViewModel
import com.android.bisabelajar.ui.feat_student.add_edit_student.AddEditStudentViewModel
import com.android.bisabelajar.ui.feat_student.list_student.ListStudentViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { MainViewModel(get(), get(), get()) }
    viewModel { LoginViewModel(get(),get()) }
    viewModel { RegisterViewModel(get(),get())}
    viewModel { ForgotPasswordViewModel(get())}
    viewModel { ListStudentViewModel(get(), get()) }
    viewModel { AddEditStudentViewModel(get())}
}