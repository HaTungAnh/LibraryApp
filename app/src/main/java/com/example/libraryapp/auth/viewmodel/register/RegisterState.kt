package com.example.libraryapp.auth.viewmodel.register

data class RegisterState(

    val isLoading: Boolean = false,
    val isSuccess: String? = "",
    val isError: String? = ""
)
