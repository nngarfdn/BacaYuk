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
    override suspend fun register(email: String, password: String):  RegisterResponse{
        return try {

            val result: AuthResult = firebaseAuthDataSource.register(email, password)
            if (result.user != null) {
                Log.d("AuthRepositoryImpl", "register: success")
                val user = User(result.user!!.uid, result.user!!.email.orEmpty(), "")
                Response.Success(user)
            } else {
                Log.d("AuthRepositoryImpl", "register: fail masuk else user null")
                Response.Error(Exception("Failed to register: User is null"))
            }
        } catch (exception: Exception) {
            Log.d("AuthRepositoryImpl", "register fail catch: ${exception.message}")
            Response.Error(exception)
        }
    }

    override suspend fun login(email: String, password: String): Flow<LoginResponse> {
//        return try {
//            val result: AuthResult = firebaseAuthDataSource.login(email, password)
//            if (result.user != null) {
//                val user = User(result.user!!.uid, result.user!!.email.orEmpty(), "")
//                Response.Success(user)
//            } else {
//                Response.Error(Exception("Failed to login: User is null"))
//            }
//        } catch (exception: Exception) {
//            Response.Error(exception)
//        }

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