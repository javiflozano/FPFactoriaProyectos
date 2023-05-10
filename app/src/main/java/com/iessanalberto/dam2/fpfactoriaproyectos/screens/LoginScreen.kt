package com.iessanalberto.dam2.fpfactoriaproyectos.screens

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.iessanalberto.dam2.fpfactoriaproyectos.R
import com.iessanalberto.dam2.fpfactoriaproyectos.navigation.AppScreens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(navController: NavController){
    Scaffold() { contentPadding ->
         BodyContentLogin(navController,
             modifier = Modifier
                 .fillMaxSize()
                 .padding(paddingValues = contentPadding))
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BodyContentLogin(navController: NavController, modifier: Modifier) {
    var user by remember { mutableStateOf("")}
    var password by remember {mutableStateOf("")}
    var context = LocalContext.current

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(painter = painterResource(id = R.drawable.logo_factoria), contentDescription = "Logo",
        modifier = Modifier.clip(RoundedCornerShape(16.dp)))
        Spacer(modifier = Modifier.height(10.dp))
        OutlinedTextField(value = user,
            onValueChange = {user = it},
            label = { Text(text = "Usuario")})
        OutlinedTextField(value = password,
            onValueChange = {password = it},
            label = { Text(text = "Contraseña")},
            visualTransformation = PasswordVisualTransformation()
            )
        Spacer(modifier = Modifier.height(10.dp))
        Button(onClick = { validar(user,password,navController,context) }) {
            Text(text = "Iniciar sesión")
        }
        Text(text = "Registrarse",
            style = TextStyle(textDecoration = TextDecoration.Underline),
            modifier = Modifier.clickable { navController.navigate(route = AppScreens.RegisterScreen.route) }
            )
    }
}

fun validar(user: String, password: String, navController: NavController, context: Context) {
    TODO("Not yet implemented")
}

