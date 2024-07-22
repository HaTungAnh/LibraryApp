package com.example.libraryapp.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.libraryapp.ui.theme.lightOrangeColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavigationAppBar(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {

    val selected = remember {
        mutableStateOf(Icons.Default.Home)
    }

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

            }
        }
    ) { innerPadding ->
        Text(
            text = "clgt",
            modifier = modifier.padding(innerPadding)
        )
    }
}