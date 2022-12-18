package com.olivierloukombo.android_app_fake_api.navigation

sealed class Screen(val route: String){
    object SplashScreen : Screen("SplashScreen")
    object Home : Screen("Home")
}
