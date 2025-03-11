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
import br.com.fiap.app.ui.theme.AppTheme
import br.com.fiap.app.ui.theme.DarkBlueGrey
import br.com.fiap.app.ui.theme.Orange

@Composable
fun RegisterScreen() {
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

        Spacer(modifier = Modifier.height(24.dp))

        CustomTextField(value = name, onValueChange = { name = it }, label = "Nome")
        Spacer(modifier = Modifier.height(12.dp))

        CustomTextField(value = email, onValueChange = { email = it }, label = "E-mail", keyboardType = KeyboardType.Email)
        Spacer(modifier = Modifier.height(12.dp))

        CustomTextField(value = password, onValueChange = { password = it }, label = "Senha", isPassword = true)
        Spacer(modifier = Modifier.height(24.dp))

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

@Composable
fun CustomTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    keyboardType: KeyboardType = KeyboardType.Text,
    isPassword: Boolean = false
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(label) },
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White, shape = RoundedCornerShape(12.dp))
            .shadow(8.dp, shape = RoundedCornerShape(12.dp)),
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
        visualTransformation = if (isPassword) PasswordVisualTransformation() else androidx.compose.ui.text.input.VisualTransformation.None,
        shape = RoundedCornerShape(12.dp),
    )
}

@Preview(showBackground = true)
@Composable
fun RegisterScreenPreview() {
    AppTheme {
        RegisterScreen()
    }
}
