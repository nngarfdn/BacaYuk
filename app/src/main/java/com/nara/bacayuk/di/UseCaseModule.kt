package com.nara.bacayuk.di

import com.nara.bacayuk.domain.usecase.AuthUseCase
import com.nara.bacayuk.domain.usecase.ReportUseCase
import com.nara.bacayuk.domain.usecase.StudentUseCase
import com.nara.bacayuk.domain.usecase.UserUseCase
import org.koin.dsl.module

val useCaseModule = module {
    single { AuthUseCase(get()) }
    single { UserUseCase(get()) }
    single { StudentUseCase(get()) }
    single { ReportUseCase(get()) }
}