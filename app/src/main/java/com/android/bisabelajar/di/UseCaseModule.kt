package com.android.bisabelajar.di

import com.android.bisabelajar.domain.usecase.AuthUseCase
import org.koin.dsl.module

val useCaseModule = module {
//    factory { AuthUseCase(get()) }
    single { AuthUseCase(get()) }
//    factory { UserUseCase(get()) }
}