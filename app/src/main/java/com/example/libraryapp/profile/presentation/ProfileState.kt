package com.example.libraryapp.profile.presentation

data class ProfileState(

    val isLoading: Boolean = false,
    val isSuccess: String? = "",
    val isError: String? = ""
)
