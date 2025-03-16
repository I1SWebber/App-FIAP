package br.com.fiap.app

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
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
import br.com.fiap.app.ui.theme.Orange
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material.icons.sharp.LocationOn

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ReportScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "ÚLTIMOS REPORTS",
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily.Serif,
                        modifier = Modifier.fillMaxWidth(),
                        color = Color.White
                    )
                },
                navigationIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.menu),
                        contentDescription = "menu sanduíche",
                        modifier = Modifier
                            .size(35.dp)
                            .offset(x = (5).dp),
                        tint = Color.White
                    )
                },
                actions = {
                    Icon(
                        painter = painterResource(id = R.drawable.filtro),
                        contentDescription = "filtro",
                        modifier = Modifier
                            .size(24.dp)
                            .offset(x = (-10).dp),
                        tint = Color.White
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Orange),
                modifier = Modifier
                    .clip(shape = RoundedCornerShape(bottomStart = 4.dp, bottomEnd = 4.dp))
            )
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp, vertical = 20.dp)
            ) {
                repeat(5) {
                    Card(
                        modifier = Modifier
                            .padding(vertical = 10.dp, horizontal = 10.dp)
                            .fillMaxWidth()
                            .height(100.dp),
                        elevation = CardDefaults.cardElevation(1.4.dp),
                        colors = CardDefaults.cardColors(containerColor = Color.White)
                    ) {

                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.padding(vertical = 10.dp, horizontal = 10.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Outlined.LocationOn,
                                contentDescription = "Localização",
                                tint = Color.Black,
                                modifier = Modifier.size(22.dp)
                            )

                            Spacer(modifier = Modifier.width(8.dp))

                            Text(
                                text = "Rua Eugênio Ulhano",
                                fontSize = 16.sp,
                                color = Color.Black
                            )
                        }

                        Text(

                            text = "Árvores caindo atrapalhando a circulação da rua a circulação da rua a circulação da rua",
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 10.dp),
                            textAlign = TextAlign.Start,
                            fontSize = 13.sp,
                            color = Color.Black
                        )
                    }
                }
            }
            Button(
                onClick = {},
                shape = CircleShape,
                modifier = Modifier
                    .offset(y = (-30).dp, x = (-5).dp)
                    .padding(horizontal = 30.dp)
                    .width(62.dp)
                    .height(62.dp)
                    .clip(CircleShape)
                    .align(Alignment.BottomEnd),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF0D47A1))
            ) {
                Text(
                    text = "+",
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    fontSize = 30.sp
                )
            }
        }
    }
}
