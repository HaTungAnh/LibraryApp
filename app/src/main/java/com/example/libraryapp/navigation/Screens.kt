package com.example.libraryapp.navigation

sealed class Screens(val route: String) {

    object LoginScreen : Screens(route = "LoginScreen")
    object RegisterScreen : Screens(route = "RegisterScreen")

    object HomeScreen : Screens(route = "HomeScreen")
    object MyBookScreen : Screens(route = "MyBookScreen")
    object SearchScreen : Screens(route = "SearchScreen")
    object ProfileScreen : Screens(route = "ProfileScreen")

    object UpdateUserInfoScreen : Screens(route = "UpdateUserInfoScreen")
}
