package com.android.bacabacabaca.di

import com.android.bacabacabaca.App
import com.android.bacabacabaca.data.preferences.abstraction.DataStoreRepository
import com.android.bacabacabaca.data.preferences.implementation.DataStoreRepositoryImpl
import org.koin.dsl.module


val preferencesModule = module {
    single<DataStoreRepository> { DataStoreRepositoryImpl(App.getContext()) }
}