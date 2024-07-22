package com.example.libraryapp.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.libraryapp.ui.theme.lightOrangeColor
import com.example.libraryapp.ui.theme.redOrangeColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavigationAppBar(
    modifier: Modifier = Modifier
) {

    val selected = remember {
        mutableStateOf(Icons.Default.Home)
    }

    val navigationController = rememberNavController()

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(text = "Title") },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = lightOrangeColor)
            )
        },
        bottomBar = {
            BottomAppBar(
                containerColor = lightOrangeColor
            ) {
                IconButton(
                    onClick = {
                        selected.value = Icons.Default.Home
                        navigationController.navigate(Screens.HomeScreen.route) {
                            popUpTo(0)
                        }
                    },
                    modifier = modifier.weight(1f)
                ) {
                    Icon(
                        imageVector = Icons.Default.Home,
                        contentDescription = "Home",
                        tint = if (selected.value == Icons.Default.Home) redOrangeColor else Color.White
                    )
                }

                IconButton(
                    onClick = {
                        selected.value = Icons.Default.Bookmark
                        navigationController.navigate(Screens.MyBookScreen.route) {
                            popUpTo(0)
                        }
                    },
                    modifier = modifier.weight(1f)
                ) {
                    Icon(
                        imageVector = Icons.Default.Bookmark,
                        contentDescription = "MyBook",
                        tint = if (selected.value == Icons.Default.Bookmark) redOrangeColor else Color.White
                    )
                }

                IconButton(
                    onClick = {
                        selected.value = Icons.Default.Search
                        navigationController.navigate(Screens.SearchScreen.route) {
                            popUpTo(0)
                        }
                    },
                    modifier = modifier.weight(1f)
                ) {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "MyBook",
                        tint = if (selected.value == Icons.Default.Search) redOrangeColor else Color.White
                    )
                }

                IconButton(
                    onClick = {
                        selected.value = Icons.Default.AccountCircle
                        navigationController.navigate(Screens.ProfileScreen.route) {
                            popUpTo(0)
                        }
                    },
                    modifier = modifier.weight(1f)
                ) {
                    Icon(
                        imageVector = Icons.Default.AccountCircle,
                        contentDescription = "MyBook",
                        tint = if (selected.value == Icons.Default.AccountCircle) redOrangeColor else Color.White
                    )
                }
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navigationController,
            startDestination = Screens.HomeScreen.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(route = Screens.HomeScreen.route) {
                HomeScreen()
            }
            composable(route = Screens.MyBookScreen.route) {
                MyBookScreen()
            }
            composable(route = Screens.SearchScreen.route) {
                SearchScreen()
            }
            composable(route = Screens.ProfileScreen.route) {
                ProfileScreen()
            }
        }
    }
}