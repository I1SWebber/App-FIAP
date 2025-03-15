package br.com.fiap.app.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.fiap.app.ui.theme.AppTheme
import br.com.fiap.app.ui.theme.DarkBlueGrey
import br.com.fiap.app.ui.theme.Orange

@Composable
fun RegisterScreen(navController: NavController) {
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(horizontal = 32.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(48.dp))

        // Título
        Text(
            text = "SeAlert",
            style = MaterialTheme.typography.headlineLarge,
            color = Orange
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Nome") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("E-mail") },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Senha") },
            modifier = Modifier.fillMaxWidth(),
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Botão de registro
        Button(
            onClick = { /* TODO: Implementar lógica de registro */ },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Orange),
            shape = RoundedCornerShape(12.dp)
        ) {
            Text("Registrar", color = Color.White)
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Alternativa de login
        Text(
            text = "Já possui uma conta?",
            color = DarkBlueGrey,
            fontSize = 14.sp,
            modifier = Modifier.clickable { /* TODO: Navegar para tela de login */ }
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Botão de login
        OutlinedButton(
            onClick = { navController.navigate("login") },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12.dp)

        ) {
            Text(text = "Entrar", color = Color.Blue)
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Botão de login com Google
        OutlinedButton(
            onClick = { /* TODO: Implementar login com Google */ },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12.dp)
        ) {
            Text(text = "Continuar com Google", color = DarkBlueGrey)
        }
    }
}



