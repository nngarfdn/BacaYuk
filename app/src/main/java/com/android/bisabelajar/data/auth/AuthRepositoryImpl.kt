package com.android.bisabelajar.data.auth

import android.content.Context
import android.util.Log
import com.android.bisabelajar.data.model.Response
import com.android.bisabelajar.data.model.User
import com.android.bisabelajar.domain.repository.AuthRepository
import com.android.bisabelajar.domain.repository.LoginResponse
import com.android.bisabelajar.domain.repository.RegisterResponse
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.AuthResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class AuthRepositoryImpl(
    private val firebaseAuthDataSource: AuthDataSource
) : AuthRepository {

    override suspend fun forgotPassword(email: String) {
        firebaseAuthDataSource.forgotPassword(email)
    }

    override suspend fun register(email: String, password: String):  Flow<RegisterResponse>{

        return flow {
            try {
                val result: AuthResult = firebaseAuthDataSource.register(email, password)
                if (result.user != null) {
                    Log.d("AuthRepositoryImpl", "register: success")
                    val user = User(result.user!!.uid, result.user!!.email.orEmpty(), "")
                    emit(Response.Success(user))
                } else {
                    Log.d("AuthRepositoryImpl", "register: fail masuk else user null")
                    emit(Response.Error(Exception("Failed to register: User is null")))
                }
            } catch (exception: Exception) {
                Log.d("AuthRepositoryImpl", "register fail catch: ${exception.message}")
                emit(Response.Error(exception))
            }
        }
    }

    override suspend fun login(email: String, password: String): Flow<LoginResponse> {
        return flow {
            val result: AuthResult = firebaseAuthDataSource.login(email, password)
            if (result.user != null) {
                val user = User(result.user!!.uid, result.user!!.email.orEmpty(), "")
                emit(Response.Success(user))
            } else {
                emit(Response.Error(Exception("Failed to login: User is null")))
            }
        }
    }

}