package com.android.bisabelajar.di

import com.android.bisabelajar.domain.usecase.AuthUseCase
import com.android.bisabelajar.domain.usecase.UserUseCase
import org.koin.dsl.module

val useCaseModule = module {
    single { AuthUseCase(get()) }
    single { UserUseCase(get()) }

}