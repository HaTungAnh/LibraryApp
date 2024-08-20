package com.example.libraryapp.navigation

sealed class Screens(val route: String) {

    data object LoginScreen : Screens(route = "LoginScreen")
    data object RegisterScreen : Screens(route = "RegisterScreen")

    data object HomeScreen : Screens(route = "HomeScreen")
    data object MyBookScreen : Screens(route = "MyBookScreen")
    data object SearchScreen : Screens(route = "SearchScreen")
    data object ProfileScreen : Screens(route = "ProfileScreen")

    data object UpdateUserInfoScreen : Screens(route = "UpdateUserInfoScreen")

    data object RequestScreen : Screens(route = "RequestScreen")
    data object AddBookScreen : Screens(route = "AddBookScreen")

    data object CameraScreen : Screens(route = "CameraScreen")
}
