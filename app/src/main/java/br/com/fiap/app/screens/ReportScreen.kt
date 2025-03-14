package br.com.fiap.app

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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

@OptIn(ExperimentalMaterial3Api::class)
class ReportScreen : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            teste()
        }
    }

    @Composable
    fun teste() {
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
                            color = Color.Black
                        )
                    },
                    navigationIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.menu),
                            contentDescription = "menu sanduíche",
                            modifier = Modifier
                                .size(35.dp)
                                .offset(x = (5).dp),
                            tint = Color.Black
                        )
                    },
                    actions = {
                        Icon(
                            painter = painterResource(id = R.drawable.filtro),
                            contentDescription = "filtro",
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
            Box(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize()
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 32.dp, vertical = 20.dp)
                ) {
                    repeat(4) {
                        Card(
                            modifier = Modifier
                                .padding(vertical = 10.dp)
                                .fillMaxWidth()
                                .height(100.dp),
                            elevation = CardDefaults.cardElevation(4.dp),
                            colors = CardDefaults.cardColors(containerColor = Color(0xFFF5F5F5))

                        ) {
                            Text(
                                text = "Local: Rua Eugênio Ulhano",
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = 10.dp,
                                        horizontal = 5.dp),
                                textAlign = TextAlign.Start,
                                fontSize = 15.sp,
                                color = Color.Black
                            )
                            Text(
                                text = "Acontecido: Árvores caindo atrapalhando a circulação da rua",
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = 5.dp),
                                textAlign = TextAlign.Start,
                                fontSize = 15.sp,
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
}