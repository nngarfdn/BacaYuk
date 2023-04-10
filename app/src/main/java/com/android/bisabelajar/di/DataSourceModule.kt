package com.android.bisabelajar.di

import com.android.bisabelajar.data.auth.AuthDataSource
import org.koin.dsl.module

val dataSourceModule = module {
    single { AuthDataSource(get()) }
}