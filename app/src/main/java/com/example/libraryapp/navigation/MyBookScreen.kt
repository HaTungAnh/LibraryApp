package com.example.libraryapp.navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun MyBookScreen(
    modifier: Modifier = Modifier,
    paddingValues: PaddingValues
) {

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(paddingValues)
    ) {
        Text(text = "MyBook")
    }
}