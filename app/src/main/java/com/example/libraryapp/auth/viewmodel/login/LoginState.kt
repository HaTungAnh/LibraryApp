package com.example.libraryapp.auth.viewmodel.login

data class LoginState(

    val isLoading: Boolean = false,
    val isSuccess: String? = "",
    val isError: String? = ""
)