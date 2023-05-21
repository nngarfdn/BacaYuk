package com.nara.bacayuk.di

import com.nara.bacayuk.App
import org.koin.dsl.module

val contextModule = module {
    single { App.getContext() }
    single { get<App>().contentResolver }
    single { get<App>().packageManager }
    single { get<App>().applicationContext }
    single { get<App>().resources }
    single { get<App>().assets }
}