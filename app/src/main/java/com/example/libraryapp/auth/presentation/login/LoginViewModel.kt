package com.example.libraryapp.auth.presentation.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.libraryapp.auth.domain.AuthRepository
import com.example.libraryapp.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val repository: AuthRepository
) : ViewModel() {

    private val _loginState = Channel<LoginState>()
    val loginState = _loginState.receiveAsFlow()

    private val _logoutState = Channel<LogoutState>()

    fun loginUser(email: String, password: String) = viewModelScope.launch {
        repository.loginUser(email, password).collect{ result ->
            when(result) {
                is Resource.Success -> {
                    _loginState.send(LoginState(isSuccess = "Login Successful"))
                }

                is Resource.Loading -> {
                    _loginState.send(LoginState(isLoading = true))
                }

                is Resource.Error -> {
                    _loginState.send(LoginState(isError = result.message))
                }
            }
        }
    }

    fun logoutUser() = viewModelScope.launch {
        repository.logoutUser().collect{ result ->
            when(result) {
                is Resource.Success -> {
                    _logoutState.send(LogoutState(isSuccess = "Logout Successful"))
                }

                is Resource.Loading -> {
                    _logoutState.send(LogoutState(isLoading = true))
                }

                is Resource.Error -> {
                    _logoutState.send(LogoutState(isError = result.message))
                }
            }
        }
    }
}