package br.com.fiap.app.screens

import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults.buttonColors
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.fiap.app.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "PERFIL DO USUÁRIO",
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily.Serif,
                        modifier = Modifier.fillMaxWidth(),
                        color = Color.Black
                    )
                },
                navigationIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.menu),
                        contentDescription = "menu sanduíche",
                        modifier = Modifier
                            .size(35.dp)
                            .offset(x = 5.dp),
                        tint = Color.Black
                    )
                },
                actions = {
                    Icon(
                        painter = painterResource(id = R.drawable.edit),
                        contentDescription = "editar perfil",
                        modifier = Modifier
                            .size(35.dp)
                            .offset(x = (-10).dp),
                        tint = Color.Black
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color(0xFF0D47A1)),
                modifier = Modifier
                    .clip(shape = RoundedCornerShape(bottomStart = 4.dp, bottomEnd = 4.dp))
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.profile),
                contentDescription = "Foto do perfil",
                modifier = Modifier
                    .size(120.dp)
                    .clip(CircleShape)
                    .border(2.dp, Color(0xFF06071C), CircleShape)
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Nome do Usuário",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "usuario@email.com",
                fontSize = 16.sp,
                color = Color.Gray
            )

            Spacer(modifier = Modifier.height(24.dp))

            Card(
                elevation = CardDefaults.cardElevation(4.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = "Informações",
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(text = "Telefone: (11) 99999-9999")
                    Text(text = "Endereço: Rua Exemplo, 123")
                    Text(text = "Cidade: São Paulo - SP")
                }
            }

            Spacer(modifier = Modifier.height(17.dp))

            Button(
                onClick = { navController.navigate("reports") },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                shape = RoundedCornerShape(12.dp),
                colors = buttonColors(Color(0xFF0D47A1))
            ) {
                Text(text = "Ver reports",
                    color = Color.White,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold)
            }

            Spacer(modifier = Modifier.height(10.dp))

            Button(
                onClick = { navController.navigate("create_report") },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                shape = RoundedCornerShape(12.dp),
                colors = buttonColors(Color(0xFF0D47A1))
            ) {
                Text(text = "Criar report",
                    color = Color.White,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold)
            }

        }
    }
}
