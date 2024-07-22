package com.example.libraryapp.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Bookmark
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Search
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.libraryapp.ui.theme.lightOrangeColor
import com.example.libraryapp.ui.theme.montserratFontFamily
import com.example.libraryapp.ui.theme.redOrangeColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavigationAppBar(
    modifier: Modifier = Modifier
) {

    val selected = remember {
        mutableStateOf(Icons.Default.Home)
    }

    val title = remember {
        mutableStateOf("Home")
    }

    val navigationController = rememberNavController()

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = title.value,
                        fontFamily = montserratFontFamily,
                        fontSize = 32.sp,
                        fontWeight = FontWeight.Bold
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = lightOrangeColor,
                    titleContentColor = redOrangeColor
                )
            )
        },
        bottomBar = {
            BottomAppBar(
                containerColor = lightOrangeColor
            ) {
                IconButton(
                    onClick = {
                        selected.value = Icons.Default.Home
                        title.value = "Home"
                        navigationController.navigate(Screens.HomeScreen.route) {
                            popUpTo(0)
                        }
                    },
                    modifier = modifier
                        .weight(1f)
                ) {
                    Icon(
                        imageVector = if (selected.value == Icons.Default.Home) Icons.Filled.Home else Icons.Outlined.Home,
                        contentDescription = "Home",
                        tint = redOrangeColor
                    )
                }

                IconButton(
                    onClick = {
                        selected.value = Icons.Default.Bookmark
                        title.value = "MyBook"
                        navigationController.navigate(Screens.MyBookScreen.route) {
                            popUpTo(0)
                        }
                    },
                    modifier = modifier.weight(1f)
                ) {
                    Icon(
                        imageVector = if (selected.value == Icons.Default.Bookmark) Icons.Filled.Bookmark else Icons.Outlined.Bookmark,
                        contentDescription = "MyBook",
                        tint = redOrangeColor
                    )
                }

                IconButton(
                    onClick = {
                        selected.value = Icons.Default.Search
                        title.value = "Search"
                        navigationController.navigate(Screens.SearchScreen.route) {
                            popUpTo(0)
                        }
                    },
                    modifier = modifier.weight(1f)
                ) {
                    Icon(
                        imageVector = if (selected.value == Icons.Default.Search) Icons.Filled.Search else Icons.Outlined.Search,
                        contentDescription = "Search",
                        tint = redOrangeColor
                    )
                }

                IconButton(
                    onClick = {
                        selected.value = Icons.Default.AccountCircle
                        title.value = "Profile"
                        navigationController.navigate(Screens.ProfileScreen.route) {
                            popUpTo(0)
                        }
                    },
                    modifier = modifier.weight(1f)
                ) {
                    Icon(
                        imageVector = if (selected.value == Icons.Default.AccountCircle) Icons.Filled.AccountCircle else Icons.Outlined.AccountCircle,
                        contentDescription = "Profile",
                        tint = redOrangeColor
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