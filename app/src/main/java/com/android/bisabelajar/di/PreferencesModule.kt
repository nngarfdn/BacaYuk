package com.android.bisabelajar.di

import com.android.bisabelajar.App
import com.android.bisabelajar.data.preferences.DataStoreRepository
import com.android.bisabelajar.data.preferences.DataStoreRepositoryImpl
import org.koin.dsl.module


val preferencesModule = module {
    single<DataStoreRepository> { DataStoreRepositoryImpl(get()) }
}