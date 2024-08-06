package com.example.libraryapp.profile.presentation

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.Password
import androidx.compose.material.icons.outlined.PeopleOutline
import androidx.compose.material.icons.outlined.Phone
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.libraryapp.ui.theme.lightOrangeColor
import com.example.libraryapp.ui.theme.montserratFontFamily
import com.example.libraryapp.ui.theme.redOrangeColor
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UpdateUserInfoScreen(
    modifier: Modifier = Modifier,
    navController: NavController
) {

    var userName by rememberSaveable { mutableStateOf("") }
    var phoneNumber by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    var passwordVisibility by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {},
                navigationIcon = {
                    IconButton(onClick = {
                        navController.popBackStack()
                    }) {
                        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = lightOrangeColor
                )
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(lightOrangeColor),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Box(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 50.dp)
            ) {
                // TODO: Update Avatar
                Image(
                    imageVector = Icons.Default.AccountCircle,
                    contentDescription = "Avatar",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(120.dp)
                        .clip(CircleShape)
                )

                Box(
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .padding(end = 15.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .size(size = 30.dp)
                            .clip(shape = CircleShape)
                            .background(color = Color.White)

                    ) {
                        IconButton(onClick = {
                            // TODO: Choose Avatar
                        }) {
                            Icon(
                                imageVector = Icons.Outlined.Edit,
                                contentDescription = "Edit Avatar"
                            )
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // TODO: Update User Name
            OutlinedTextField(
                value = userName,
                onValueChange = { userName = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp, end = 20.dp),
                label = { Text( text = "Username", fontFamily = montserratFontFamily, fontWeight = FontWeight.SemiBold) },
                leadingIcon = { Icon(imageVector = Icons.Outlined.PeopleOutline, contentDescription = null) },
                shape = RoundedCornerShape(15.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White,
                    disabledContainerColor = Color.White,
                    focusedBorderColor = Color.Black,
                    unfocusedBorderColor = Color.Black,
                )
            )

            // TODO: Update Phone Number
            OutlinedTextField(
                value = phoneNumber,
                onValueChange = { phoneNumber = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp, end = 20.dp),
                label = { Text( text = "Phone Number", fontFamily = montserratFontFamily, fontWeight = FontWeight.SemiBold) },
                leadingIcon = { Icon(imageVector = Icons.Outlined.Phone, contentDescription = null) },
                shape = RoundedCornerShape(15.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White,
                    disabledContainerColor = Color.White,
                    focusedBorderColor = Color.Black,
                    unfocusedBorderColor = Color.Black,
                )
            )

            // TODO: Update Password Number
            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp, end = 20.dp),
                label = { Text( text = "Password", fontFamily = montserratFontFamily, fontWeight = FontWeight.SemiBold) },
                leadingIcon = { Icon(imageVector = Icons.Outlined.Lock, contentDescription = null) },
                shape = RoundedCornerShape(15.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White,
                    disabledContainerColor = Color.White,
                    focusedBorderColor = Color.Black,
                    unfocusedBorderColor = Color.Black,
                ),
                visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                trailingIcon = {
                    IconButton(onClick = { passwordVisibility = !passwordVisibility }) {
                        Icon(
                            imageVector = if (passwordVisibility) Icons.Filled.VisibilityOff else Icons.Filled.Visibility,
                            contentDescription = "Toggle password visibility"
                        )
                    }
                },
            )

            Spacer(modifier = Modifier.height(80.dp))

            // TODO: Save Changes
            OutlinedButton(
                onClick = {

                    navController.popBackStack()
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .padding(start = 16.dp, end = 16.dp),
                shape = RoundedCornerShape(15.dp),
                border = BorderStroke(1.dp, color = redOrangeColor)
            ) {
                Text(
                    text = "Save Changes",
                    fontFamily = montserratFontFamily,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 20.sp,
                    color = redOrangeColor
                )
            }
        }
    }
}

@Preview
@Composable
private fun PreviewUpdateUserInfoScreen() {
    UpdateUserInfoScreen(navController = rememberNavController())
}