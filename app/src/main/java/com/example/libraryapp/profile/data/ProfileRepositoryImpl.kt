package com.example.libraryapp.profile.data

import android.util.Log
import com.example.libraryapp.util.Resource
import com.example.libraryapp.profile.domain.ProfileRepository
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.UserInfo
import com.google.firebase.database.DatabaseReference
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ProfileRepositoryImpl @Inject constructor(
    private val firebaseAuth: FirebaseAuth,
    private val database: DatabaseReference
) : ProfileRepository {

    override fun getUserInfo(email: String, password: String): Flow<Resource<UserInfo>> {
        return flow {
            emit(Resource.Loading())
            val uId = firebaseAuth.currentUser?.uid
            var userInfo: UserInfo? = null
            database.child("users").child(uId!!).get().addOnSuccessListener {
                userInfo = it.getValue(UserInfo::class.java)
                Log.i("firebase", "Got value ${it.value}")
            }.addOnFailureListener {
                Log.e("firebase", "Error getting data", it)
            }
            if (userInfo != null) {
                emit(Resource.Success(userInfo))
            } else {
                emit(Resource.Error("Error"))
            }
        }
    }

    override fun updateUserInfo(email: String, password: String): Flow<Resource<UserInfo>> {
        return flow {

        }
    }


}