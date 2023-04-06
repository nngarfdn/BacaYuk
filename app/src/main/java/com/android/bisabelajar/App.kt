package com.android.bisabelajar

import android.app.Application
import com.android.bisabelajar.di.preferencesModule
import com.android.bisabelajar.di.viewModelModule
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class App: Application() {

    init {
        instance = this
    }

    companion object {
        private var instance: App? = null

        fun getContext() : App {
            return instance as App
        }
    }

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.NONE)
            modules(listOf(
                preferencesModule, viewModelModule
            ))
        }
    }

}