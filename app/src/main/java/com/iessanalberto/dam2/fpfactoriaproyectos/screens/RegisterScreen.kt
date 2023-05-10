package com.iessanalberto.dam2.fpfactoriaproyectos.screens

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
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
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.iessanalberto.dam2.fpfactoriaproyectos.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterScreen(navController: NavController){
    Scaffold() {contentPadding ->
        BodyContentRegister(navController,modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues = contentPadding))

    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BodyContentRegister(navController: NavController,modifier: Modifier) {
    var context = LocalContext.current
    var user by remember {mutableStateOf("")}
    var password by remember {mutableStateOf("")}
    var repeatPassword by remember {mutableStateOf("")}
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(painter = painterResource(id = R.drawable.logo_factoria),
            contentDescription = "Logo",
            modifier = Modifier.clip(RoundedCornerShape(16.dp))
            )
        Spacer(modifier = Modifier.height(10.dp))
        OutlinedTextField(value = user, 
            onValueChange = {user = it},
            label = { Text(text = "Usuario")}
            )
        OutlinedTextField(value = password, 
            onValueChange = {password = it},
            label = { Text(text = "Contraseña")},
            keyboardOptions = KeyboardOptions
                (keyboardType = KeyboardType.Password),
            visualTransformation = PasswordVisualTransformation()
            )
        OutlinedTextField(value = repeatPassword,
            onValueChange = {repeatPassword = it},
            label = { Text(text = "Repite la contraseña")},
            keyboardOptions = KeyboardOptions
                (keyboardType = KeyboardType.Password),
            visualTransformation = PasswordVisualTransformation()
            )
        Spacer(modifier = Modifier.height(10.dp))
        Button(onClick = { registrar(user,password,repeatPassword,navController,context) }) {
            Text(text = "Registrarse")
        }
    }
}

fun registrar(
    user: String,
    password: String,
    repeatPassword: String,
    navController: NavController,
    context: Context
) {
    if (password != repeatPassword){
        Toast.makeText(context,"No coinciden las contraseñas",Toast.LENGTH_SHORT).show()
    }

}
