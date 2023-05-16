package com.android.bisabelajar.di

import com.android.bisabelajar.domain.usecase.AuthUseCase
import com.android.bisabelajar.domain.usecase.StudentUseCase
import com.android.bisabelajar.domain.usecase.UserUseCase
import org.koin.core.scope.get
import org.koin.dsl.module
import org.koin.dsl.single

val useCaseModule = module {
    single { AuthUseCase(get()) }
    single { UserUseCase(get()) }
    single { StudentUseCase(get()) }
}