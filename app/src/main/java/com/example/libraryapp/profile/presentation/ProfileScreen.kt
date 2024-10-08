package com.example.libraryapp.profile.presentation

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.libraryapp.auth.presentation.login.LoginViewModel
import com.example.libraryapp.ui.theme.lightOrangeColor
import com.example.libraryapp.ui.theme.montserratFontFamily
import com.example.libraryapp.ui.theme.redOrangeColor
import kotlinx.coroutines.launch

@Composable
fun ProfileScreen(
    modifier: Modifier = Modifier,
    loginViewModel: LoginViewModel = hiltViewModel(),
    navController: NavController,
    paddingValues: PaddingValues
) {

    val scope = rememberCoroutineScope()

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = lightOrangeColor)
            .padding(paddingValues),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(32.dp))

        // TODO: Load Avatar
        Image(
            imageVector = Icons.Default.AccountCircle,
            contentDescription = "Avatar",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(120.dp)
                .clip(CircleShape)
        )

        // TODO: User Name
        Text(
            text = "Name",
            fontFamily = montserratFontFamily,
            fontWeight = FontWeight.Medium,
            fontSize = 24.sp
        )

        Spacer(modifier = Modifier.height(32.dp))

        OutlinedButton(
            onClick = {
                navController.navigate("UpdateUserInfoScreen")
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .padding(start = 16.dp, end = 16.dp),
            shape = RoundedCornerShape(15.dp),
            border = BorderStroke(1.dp, color = Color.Black)
        ) {
            Text(
                text = "Edit Profile",
                fontFamily = montserratFontFamily,
                fontWeight = FontWeight.SemiBold,
                fontSize = 20.sp,
                color = Color.Black
            )
        }

        Spacer(modifier = Modifier.height(15.dp))

        // TODO: Change Destination
        OutlinedButton(
            onClick = {

            },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .padding(start = 16.dp, end = 16.dp),
            shape = RoundedCornerShape(15.dp),
            border = BorderStroke(1.dp, color = Color.Black)
        ) {
            Text(
                text = "Light Theme",
                fontFamily = montserratFontFamily,
                fontWeight = FontWeight.SemiBold,
                fontSize = 20.sp,
                color = Color.Black
            )
        }

        Spacer(modifier = Modifier.height(15.dp))

        // TODO: Change Destination
        OutlinedButton(
            onClick = {

            },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .padding(start = 16.dp, end = 16.dp),
            shape = RoundedCornerShape(15.dp),
            border = BorderStroke(1.dp, color = Color.Black)
        ) {
            Text(
                text = "Notifications",
                fontFamily = montserratFontFamily,
                fontWeight = FontWeight.SemiBold,
                fontSize = 20.sp,
                color = Color.Black
            )
        }

        Spacer(modifier = Modifier.height(15.dp))

        // TODO: Change Destination
        OutlinedButton(
            onClick = {

            },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .padding(start = 16.dp, end = 16.dp),
            shape = RoundedCornerShape(15.dp),
            border = BorderStroke(1.dp, color = Color.Black)
        ) {
            Text(
                text = "Help",
                fontFamily = montserratFontFamily,
                fontWeight = FontWeight.SemiBold,
                fontSize = 20.sp,
                color = Color.Black
            )
        }

        Spacer(modifier = Modifier.height(40.dp))

        OutlinedButton(
            onClick = {
                scope.launch {
                    loginViewModel.logoutUser()
                }
                navController.navigate("LoginScreen")
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .padding(start = 16.dp, end = 16.dp),
            shape = RoundedCornerShape(15.dp),
            border = BorderStroke(1.dp, color = redOrangeColor)
        ) {
            Text(
                text = "Logout",
                fontFamily = montserratFontFamily,
                fontWeight = FontWeight.SemiBold,
                fontSize = 20.sp,
                color = redOrangeColor
            )
        }
    }
}