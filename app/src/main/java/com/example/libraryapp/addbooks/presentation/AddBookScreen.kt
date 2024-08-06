package com.example.libraryapp.addbooks.presentation

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.libraryapp.ui.theme.montserratFontFamily
import com.example.libraryapp.ui.theme.redOrangeColor

@Composable
fun AddBookScreen(
    modifier: Modifier = Modifier,
    paddingValues: PaddingValues,
    navController: NavController
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(paddingValues)
            .background(color = Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // TODO: Navigate to AddBookScreen
        OutlinedButton(
            onClick = {

            },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .padding(start = 16.dp, end = 16.dp),
            shape = RoundedCornerShape(15.dp),
            border = BorderStroke(1.dp, color = redOrangeColor)
        ) {
            Text(
                text = "Add a new book!",
                fontFamily = montserratFontFamily,
                fontWeight = FontWeight.SemiBold,
                fontSize = 20.sp,
                color = redOrangeColor
            )
        }
    }
}

@Preview
@Composable
private fun PreviewAddBookScreen() {
    AddBookScreen(
        paddingValues = PaddingValues(16.dp),
        navController = rememberNavController()
    )
}