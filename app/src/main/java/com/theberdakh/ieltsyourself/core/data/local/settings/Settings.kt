package com.theberdakh.ieltsyourself.core.data.local.settings

class Settings {
    val login: Login = Login.LOGGED_OUT
}
enum class Login {
    LOGGED_IN, LOGGED_OUT
}