package com.iessanalberto.dam2.fpfactoriaproyectos.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.iessanalberto.dam2.fpfactoriaproyectos.screens.LoginScreen
import com.iessanalberto.dam2.fpfactoriaproyectos.screens.RegisterScreen

@Composable
fun AppNavigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = AppScreens.LoginScreen.route){
        composable(route = AppScreens.LoginScreen.route) { LoginScreen(navController = navController)}
        composable(route = AppScreens.RegisterScreen.route) { RegisterScreen(navController = navController)}
    }
}