package com.example.libraryapp.auth.presentation.register

data class RegisterState(

    val isLoading: Boolean = false,
    val isSuccess: String? = "",
    val isError: String? = ""
)
