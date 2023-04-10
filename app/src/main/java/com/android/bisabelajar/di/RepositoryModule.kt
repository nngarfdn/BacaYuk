package com.android.bisabelajar.di

import com.android.bisabelajar.data.auth.AuthRepositoryImpl
import com.android.bisabelajar.data.preferences.DataStoreRepository
import com.android.bisabelajar.data.preferences.DataStoreRepositoryImpl
import com.android.bisabelajar.data.user.UserRepositoryImpl
import com.android.bisabelajar.domain.repository.AuthRepository
import com.android.bisabelajar.domain.repository.UserRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<UserRepository> { UserRepositoryImpl(get()) }
    single<AuthRepository> { AuthRepositoryImpl(get(), get()) }
}