package com.android.bacabacabaca

import android.app.Application
import androidx.lifecycle.ViewModelProvider.NewInstanceFactory.Companion.instance
import com.android.bacabacabaca.di.preferencesModule
import com.android.bacabacabaca.di.viewModelModule
import org.koin.android.ext.koin.androidLogger
import org.koin.android.ext.koin.androidContext
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