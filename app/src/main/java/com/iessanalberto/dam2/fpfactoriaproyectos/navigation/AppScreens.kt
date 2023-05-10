package com.iessanalberto.dam2.fpfactoriaproyectos.navigation

sealed class AppScreens(val route:String){
    object LoginScreen: AppScreens (route = "login_screen")
    object RegisterScreen: AppScreens(route = "register_screen")
}
