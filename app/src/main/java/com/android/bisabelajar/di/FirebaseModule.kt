package com.android.bisabelajar.di
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val firebaseModule = module {
    factory { FirebaseApp.initializeApp(androidContext()) }
    single { FirebaseAuth.getInstance(get()) }
    single { FirebaseFirestore.getInstance() }
}