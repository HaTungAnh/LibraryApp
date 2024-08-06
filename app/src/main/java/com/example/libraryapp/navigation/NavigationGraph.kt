package com.example.libraryapp.navigation

import androidx.compose.foundation.border
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.libraryapp.auth.presentation.login.LoginScreen
import com.example.libraryapp.auth.presentation.register.RegisterScreen
import com.example.libraryapp.profile.presentation.ProfileScreen
import com.example.libraryapp.profile.presentation.UpdateUserInfoScreen
import com.example.libraryapp.ui.theme.lightOrangeColor
import com.example.libraryapp.ui.theme.montserratFontFamily
import com.example.libraryapp.ui.theme.redOrangeColor
import com.google.firebase.auth.FirebaseAuth

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavigationGraph(
    navController: NavHostController = rememberNavController(),
    auth: FirebaseAuth
) {
    val selected = remember {
        mutableStateOf(Icons.Default.Home)
    }

    val title = remember {
        mutableStateOf("Home")
    }

    NavHost(
        navController = navController,
        startDestination = if(auth.currentUser == null) Screens.LoginScreen.route else Screens.HomeScreen.route
    ) {
        composable(route = Screens.LoginScreen.route) {
            LoginScreen(navController = navController)
        }
        composable(route = Screens.RegisterScreen.route) {
            RegisterScreen(navController = navController)
        }
        composable(route = Screens.HomeScreen.route) {
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
                        ),
                        modifier = Modifier
                            .border(1.dp, color = redOrangeColor, shape = RoundedCornerShape(
                                bottomStart = 20.dp,
                                bottomEnd = 20.dp
                            )
                            )
                    )
                },
                bottomBar = {
                    BottomAppBar(
                        containerColor = lightOrangeColor,
                        modifier = Modifier
                            .border(1.dp, color = redOrangeColor, shape = RoundedCornerShape(
                                topStart = 20.dp,
                                topEnd = 20.dp
                            )
                            )
                    ) {
                        IconButton(
                            onClick = {
                                selected.value = Icons.Default.Home
                                title.value = "Home"
                                navController.navigate(Screens.HomeScreen.route) {
                                    popUpTo(0)
                                }
                            },
                            modifier = Modifier
                                .weight(1f)
                        ) {
                            Icon(
                                imageVector = if (selected.value == Icons.Default.Home) Icons.Filled.Home else Icons.Outlined.Home,
                                contentDescription = "Home",
                                tint = redOrangeColor
                            )
                        }

                        // TODO: Fix Icons always filled
                        IconButton(
                            onClick = {
                                selected.value = Icons.Default.Bookmark
                                title.value = "MyBook"
                                navController.navigate(Screens.MyBookScreen.route) {
                                    popUpTo(0)
                                }
                            },
                            modifier = Modifier.weight(1f)
                        ) {
                            Icon(
                                imageVector = if (selected.value == Icons.Default.Bookmark) Icons.Filled.Bookmark else Icons.Outlined.Bookmark,
                                contentDescription = "MyBook",
                                tint = redOrangeColor
                            )
                        }

                        // TODO: Fix Icons can't filled
                        IconButton(
                            onClick = {
                                selected.value = Icons.Default.Search
                                title.value = "Search"
                                navController.navigate(Screens.SearchScreen.route) {
                                    popUpTo(0)
                                }
                            },
                            modifier = Modifier.weight(1f)
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
                                navController.navigate(Screens.ProfileScreen.route) {
                                    popUpTo(0)
                                }
                            },
                            modifier = Modifier.weight(1f)
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
                HomeScreen(paddingValues = innerPadding)
            }
        }
        composable(route = Screens.MyBookScreen.route) {
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
                        ),
                        modifier = Modifier
                            .border(1.dp, color = redOrangeColor, shape = RoundedCornerShape(
                                bottomStart = 20.dp,
                                bottomEnd = 20.dp
                            )
                            )
                    )
                },
                bottomBar = {
                    BottomAppBar(
                        containerColor = lightOrangeColor,
                        modifier = Modifier
                            .border(1.dp, color = redOrangeColor, shape = RoundedCornerShape(
                                topStart = 20.dp,
                                topEnd = 20.dp
                            )
                            )
                    ) {
                        IconButton(
                            onClick = {
                                selected.value = Icons.Default.Home
                                title.value = "Home"
                                navController.navigate(Screens.HomeScreen.route) {
                                    popUpTo(0)
                                }
                            },
                            modifier = Modifier
                                .weight(1f)
                        ) {
                            Icon(
                                imageVector = if (selected.value == Icons.Default.Home) Icons.Filled.Home else Icons.Outlined.Home,
                                contentDescription = "Home",
                                tint = redOrangeColor
                            )
                        }

                        // TODO: Fix Icons always filled
                        IconButton(
                            onClick = {
                                selected.value = Icons.Default.Bookmark
                                title.value = "MyBook"
                                navController.navigate(Screens.MyBookScreen.route) {
                                    popUpTo(0)
                                }
                            },
                            modifier = Modifier.weight(1f)
                        ) {
                            Icon(
                                imageVector = if (selected.value == Icons.Default.Bookmark) Icons.Filled.Bookmark else Icons.Outlined.Bookmark,
                                contentDescription = "MyBook",
                                tint = redOrangeColor
                            )
                        }

                        // TODO: Fix Icons can't filled
                        IconButton(
                            onClick = {
                                selected.value = Icons.Default.Search
                                title.value = "Search"
                                navController.navigate(Screens.SearchScreen.route) {
                                    popUpTo(0)
                                }
                            },
                            modifier = Modifier.weight(1f)
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
                                navController.navigate(Screens.ProfileScreen.route) {
                                    popUpTo(0)
                                }
                            },
                            modifier = Modifier.weight(1f)
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
                MyBookScreen(paddingValues = innerPadding)
            }
        }
        composable(route = Screens.SearchScreen.route) {
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
                        ),
                        modifier = Modifier
                            .border(1.dp, color = redOrangeColor, shape = RoundedCornerShape(
                                bottomStart = 20.dp,
                                bottomEnd = 20.dp
                            )
                            )
                    )
                },
                bottomBar = {
                    BottomAppBar(
                        containerColor = lightOrangeColor,
                        modifier = Modifier
                            .border(1.dp, color = redOrangeColor, shape = RoundedCornerShape(
                                topStart = 20.dp,
                                topEnd = 20.dp
                            )
                            )
                    ) {
                        IconButton(
                            onClick = {
                                selected.value = Icons.Default.Home
                                title.value = "Home"
                                navController.navigate(Screens.HomeScreen.route) {
                                    popUpTo(0)
                                }
                            },
                            modifier = Modifier
                                .weight(1f)
                        ) {
                            Icon(
                                imageVector = if (selected.value == Icons.Default.Home) Icons.Filled.Home else Icons.Outlined.Home,
                                contentDescription = "Home",
                                tint = redOrangeColor
                            )
                        }

                        // TODO: Fix Icons always filled
                        IconButton(
                            onClick = {
                                selected.value = Icons.Default.Bookmark
                                title.value = "MyBook"
                                navController.navigate(Screens.MyBookScreen.route) {
                                    popUpTo(0)
                                }
                            },
                            modifier = Modifier.weight(1f)
                        ) {
                            Icon(
                                imageVector = if (selected.value == Icons.Default.Bookmark) Icons.Filled.Bookmark else Icons.Outlined.Bookmark,
                                contentDescription = "MyBook",
                                tint = redOrangeColor
                            )
                        }

                        // TODO: Fix Icons can't filled
                        IconButton(
                            onClick = {
                                selected.value = Icons.Default.Search
                                title.value = "Search"
                                navController.navigate(Screens.SearchScreen.route) {
                                    popUpTo(0)
                                }
                            },
                            modifier = Modifier.weight(1f)
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
                                navController.navigate(Screens.ProfileScreen.route) {
                                    popUpTo(0)
                                }
                            },
                            modifier = Modifier.weight(1f)
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
                SearchScreen(paddingValues = innerPadding)
            }
        }
        composable(route = Screens.ProfileScreen.route) {
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
                        ),
                        modifier = Modifier
                            .border(1.dp, color = redOrangeColor, shape = RoundedCornerShape(
                                bottomStart = 20.dp,
                                bottomEnd = 20.dp
                            )
                            )
                    )
                },
                bottomBar = {
                    BottomAppBar(
                        containerColor = lightOrangeColor,
                        modifier = Modifier
                            .border(1.dp, color = redOrangeColor, shape = RoundedCornerShape(
                                topStart = 20.dp,
                                topEnd = 20.dp
                            )
                            )
                    ) {
                        IconButton(
                            onClick = {
                                selected.value = Icons.Default.Home
                                title.value = "Home"
                                navController.navigate(Screens.HomeScreen.route) {
                                    popUpTo(0)
                                }
                            },
                            modifier = Modifier
                                .weight(1f)
                        ) {
                            Icon(
                                imageVector = if (selected.value == Icons.Default.Home) Icons.Filled.Home else Icons.Outlined.Home,
                                contentDescription = "Home",
                                tint = redOrangeColor
                            )
                        }

                        // TODO: Fix Icons always filled
                        IconButton(
                            onClick = {
                                selected.value = Icons.Default.Bookmark
                                title.value = "MyBook"
                                navController.navigate(Screens.MyBookScreen.route) {
                                    popUpTo(0)
                                }
                            },
                            modifier = Modifier.weight(1f)
                        ) {
                            Icon(
                                imageVector = if (selected.value == Icons.Default.Bookmark) Icons.Filled.Bookmark else Icons.Outlined.Bookmark,
                                contentDescription = "MyBook",
                                tint = redOrangeColor
                            )
                        }

                        // TODO: Fix Icons can't filled
                        IconButton(
                            onClick = {
                                selected.value = Icons.Default.Search
                                title.value = "Search"
                                navController.navigate(Screens.SearchScreen.route) {
                                    popUpTo(0)
                                }
                            },
                            modifier = Modifier.weight(1f)
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
                                navController.navigate(Screens.ProfileScreen.route) {
                                    popUpTo(0)
                                }
                            },
                            modifier = Modifier.weight(1f)
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
                ProfileScreen(navController = navController, paddingValues = innerPadding)
            }
        }
        composable(route = Screens.UpdateUserInfoScreen.route) {
            UpdateUserInfoScreen(navController = navController)
        }
    }
}