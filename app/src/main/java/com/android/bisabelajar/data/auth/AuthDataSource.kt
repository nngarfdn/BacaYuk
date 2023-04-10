package com.android.bisabelajar.data.auth

import android.content.Context
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.tasks.await

class AuthDataSource(val context: Context) {
//    private val firebaseAuth = Firebase.auth

    init {
        FirebaseApp.initializeApp(context)
    }

    suspend fun login(email: String, password: String): AuthResult {
        FirebaseApp.initializeApp(context)
        val firebaseAuth = FirebaseAuth.getInstance()
        return firebaseAuth.signInWithEmailAndPassword(email, password).await()
    }

    suspend fun register(email: String, password: String): AuthResult {
        FirebaseApp.initializeApp(context)
        val firebaseAuth = FirebaseAuth.getInstance()
        return firebaseAuth.createUserWithEmailAndPassword(email, password).await()
    }

}