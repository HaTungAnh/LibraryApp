package com.example.libraryapp.navigation

sealed class Screens(val route: String) {

    object LoginScreen : Screens(route = "LoginScreen")
    object RegisterScreen : Screens(route = "RegisterScreen")
}
