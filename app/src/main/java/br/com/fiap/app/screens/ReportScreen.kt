package br.com.fiap.app

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.fiap.app.database.repository.OcorridoRepository
import br.com.fiap.app.model.Ocorrido
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ReportScreen(navController: NavController) {
    val context = LocalContext.current
    val ocorridoRepository = OcorridoRepository(context)

    var listaOcorridosState by remember { mutableStateOf<List<Ocorrido>>(emptyList()) }

    // 🚀 Sempre que a tela for reexibida, recarrega os dados
    val navBackStackEntry = rememberUpdatedState(navController.currentBackStackEntry)

    LaunchedEffect(navBackStackEntry.value) {
        listaOcorridosState = ocorridoRepository.listarOcorridos()
    }


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
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp)
                        .verticalScroll(rememberScrollState())
                ) {
                    if (listaOcorridosState.isEmpty()) {
                        Text(
                            text = "Nenhum report encontrado.",
                            modifier = Modifier.align(Alignment.CenterHorizontally),
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Gray
                        )
                    } else {
                        listaOcorridosState.forEach { ocorrido ->
                            CardEndereco(endereco = ocorrido.toEndereco())
                            Spacer(modifier = Modifier.height(8.dp))
                        }
                    }
                }
            }

            Button(
                onClick = { navController.navigate("create_report") },
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
