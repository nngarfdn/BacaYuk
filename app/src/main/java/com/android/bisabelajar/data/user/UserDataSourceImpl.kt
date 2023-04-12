package com.android.bisabelajar.data.user

import android.util.Log
import com.android.bisabelajar.data.model.Response
import com.android.bisabelajar.data.model.User
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.tasks.await

class UserDataSourceImpl(private val firestore: FirebaseFirestore): UserDataSource{


    override fun getUserFromFirestore(id: String): Flow<Response<User>> = flow {
        val snapshot = firestore.collection("users").document(id).get().await()
        val user = snapshot.toObject(User::class.java)
        if (user != null) {
            emit(Response.Success(user)) // jika dapat ditemukan data user dari Firestore
        } else {
            emit(Response.Error(null,"User not found.")) // jika tidak dapat ditemukan data user dari Firestore
        }
    }.catch {
        emit(Response.Error(null,"Failed to fetch user data from Firestore."))
        Log.e("UserDataSourceImpl", "Failed to fetch user data from Firestore.", it)
    }

    override suspend fun addUpdateUserToFirestore(user: User): Boolean {
        return try {
            val firestoreInstance = FirebaseFirestore.getInstance()
            val documentReference = firestoreInstance.collection("Users").document(user.id)
            documentReference.set(user).await()
            true // kembalikan nilai boolean true jika operasi berhasil
        } catch (e: Exception) {
            Log.e("UserDataSourceImpl", "Error adding or updating user to Firestore.", e)
            false // kembalikan nilai boolean false jika operasi gagal
        }
    }


}