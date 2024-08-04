package com.example.libraryapp.profile.viewmodel

import com.example.libraryapp.util.Resource
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.UserInfo
import kotlinx.coroutines.flow.Flow

interface ProfileRepository {

    fun getUserInfo(email: String, password: String): Flow<Resource<UserInfo>>
    fun updateUserInfo(email: String, password: String): Flow<Resource<UserInfo>>
}