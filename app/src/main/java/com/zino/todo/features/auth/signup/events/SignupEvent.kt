package com.zino.todo.features.auth.signup.events

sealed class SignupEvent {
    data class UpdateName(val firstname: String): SignupEvent()
    data class UpdateUsername(val username: String): SignupEvent()
    data class UpdatePassword(val password: String): SignupEvent()
    data object TogglePasswordVisibility: SignupEvent()
    data object Submit: SignupEvent()
}