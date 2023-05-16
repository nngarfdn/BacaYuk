package com.android.bisabelajar.di

import com.android.bisabelajar.data.auth.AuthDataSource
import com.android.bisabelajar.data.auth.AuthRepositoryImpl
import com.android.bisabelajar.data.model.Student
import com.android.bisabelajar.data.student.StudentDataSource
import com.android.bisabelajar.data.student.StudentDataSourceImpl
import com.android.bisabelajar.data.user.UserDataSource
import com.android.bisabelajar.data.user.UserDataSourceImpl
import com.android.bisabelajar.domain.repository.AuthRepository
import org.koin.dsl.module

val dataSourceModule = module {
    single { AuthDataSource(get()) }
    single<UserDataSource> { UserDataSourceImpl(get()) }
    single<StudentDataSource> { StudentDataSourceImpl() }
}