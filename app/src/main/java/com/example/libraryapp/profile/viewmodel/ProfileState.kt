package com.example.libraryapp.profile.viewmodel

data class ProfileState(

    val isLoading: Boolean = false,
    val isSuccess: String? = "",
    val isError: String? = ""
)
