package com.android.bisabelajar.data.auth

import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.tasks.await

class AuthDataSource(private val firebaseAuth: FirebaseAuth) {

    suspend fun login(email: String, password: String): AuthResult {
        return firebaseAuth.signInWithEmailAndPassword(email, password).await()
    }

    suspend fun register(email: String, password: String): AuthResult {
        return firebaseAuth.createUserWithEmailAndPassword(email, password).await()
    }

    suspend fun forgotPassword(email: String){
        firebaseAuth.sendPasswordResetEmail(email).await()
    }

    suspend fun logOut() {
        firebaseAuth.signOut()
    }
}