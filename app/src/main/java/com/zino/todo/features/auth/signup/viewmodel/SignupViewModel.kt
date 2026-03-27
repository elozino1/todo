package com.zino.todo.features.auth.signup.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.zino.todo.features.auth.signup.events.SignupEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SignupViewModel @Inject constructor(): ViewModel() {

    var signupState by mutableStateOf(SignupState())
        private set

    fun onEvent(event: SignupEvent) {
        when (event) {
            SignupEvent.TogglePasswordVisibility -> {

            }
            is SignupEvent.UpdateName -> {
                signupState = signupState.copy(name = event.firstname)
            }
            is SignupEvent.UpdateUsername -> {
                signupState = signupState.copy(username = event.username)
            }
            is SignupEvent.UpdatePassword -> {
                signupState = signupState.copy(password = event.password)
            }
            SignupEvent.Submit -> println(signupState)
        }
    }
}

data class SignupState(
    var username: String = "",
    var name: String = "",
    var password: String = "",
)