package com.nara.bacayuk

import android.app.Application
import com.google.firebase.FirebaseApp
import com.nara.bacayuk.di.*
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

        FirebaseApp.initializeApp(this)

        startKoin {
            androidLogger(Level.NONE)
            androidContext(this@App)
            modules(listOf(
                firebaseModule,
                preferencesModule,
                viewModelModule,
                dataSourceModule,
                repositoryModule,
                useCaseModule,
                contextModule
            ))
        }
    }
}