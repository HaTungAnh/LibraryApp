package com.example.libraryapp.profile.domain

import com.example.libraryapp.util.Resource
import com.google.firebase.auth.UserInfo
import kotlinx.coroutines.flow.Flow

interface ProfileRepository {

    fun getUserInfo(email: String, password: String): Flow<Resource<UserInfo>>
    fun updateUserInfo(email: String, password: String): Flow<Resource<UserInfo>>
}