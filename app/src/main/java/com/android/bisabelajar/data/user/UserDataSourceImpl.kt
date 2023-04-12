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


    override fun getUserFromFirestore(id: String): Flow<Response<User>> {
        Log.d("UserDataSourceImpl", "getUserFromFirestore: called")
        return flow {
            val firestoreInstance = FirebaseFirestore.getInstance()
            val snapshot = firestoreInstance.collection("Users").document(id).get().await()
            //log
            Log.d("UserDataSourceImpl", "getUserFromFirestore: $snapshot")
            val user = snapshot.toObject(User::class.java)
            if (user != null) {
                emit(Response.Success(user)) // jika dapat ditemukan data user dari Firestore
                Log.d("UserDataSourceImpl", "getUserFromFirestore: $user")
            } else {
                emit(Response.Error(null,"User not found."))
                Log.d("UserDataSourceImpl", "getUserFromFirestore: Notfound")// jika tidak dapat ditemukan data user dari Firestore
            }
        }.catch {
            emit(Response.Error(null,"Failed to fetch user data from Firestore."))
            Log.e("UserDataSourceImpl", "Failed to fetch user data from Firestore.", it)
        }
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