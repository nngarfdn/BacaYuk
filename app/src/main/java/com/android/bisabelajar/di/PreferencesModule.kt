package com.android.bisabelajar.di

import com.android.bisabelajar.App
import com.android.bisabelajar.data.preferences.interfaces.DataStoreRepository
import com.android.bisabelajar.data.preferences.implementation.DataStoreRepositoryImpl
import org.koin.dsl.module


val preferencesModule = module {
    single<DataStoreRepository> { DataStoreRepositoryImpl(App.getContext()) }
}