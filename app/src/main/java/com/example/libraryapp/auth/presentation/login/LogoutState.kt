package com.example.libraryapp.auth.presentation.login

data class LogoutState(

    val isLoading: Boolean = false,
    val isSuccess: String? = "",
    val isError: String? = ""
)
