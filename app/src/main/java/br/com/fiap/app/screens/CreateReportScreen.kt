package br.com.fiap.app

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.fiap.app.Endereco
import br.com.fiap.app.database.repository.OcorridoRepository
import br.com.fiap.app.model.Ocorrido
import br.com.fiap.app.service.RetrofitFactory
import br.com.fiap.app.ui.theme.AppTheme
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateReportScreen(navController: NavController) {
    val context = LocalContext.current
    val ocorridoRepository = OcorridoRepository(context)

    var cepState by remember { mutableStateOf("") }
    var descricaoState by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "CRIAR REPORT",
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
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 20.dp, vertical = 16.dp)
        ) {

            OutlinedTextField(
                value = cepState,
                onValueChange = { cepState = it },
                modifier = Modifier.fillMaxWidth(),
                label = { Text("CEP do Ocorrido") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = descricaoState,
                onValueChange = { descricaoState = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(min = 100.dp),
                label = { Text("Descrição do Ocorrido") },
                maxLines = 4,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
            )

            Spacer(modifier = Modifier.height(24.dp))

            val scope = rememberCoroutineScope()

            Button(
                onClick = {
                    val call = RetrofitFactory().getCepService().getEndereco(cepState)
                    call.enqueue(object : Callback<Endereco> {
                        override fun onResponse(call: Call<Endereco>, response: Response<Endereco>) {
                            response.body()?.let { endereco ->
                                endereco.descricao = descricaoState
                                val novoOcorrido = Ocorrido(
                                    cep = endereco.cep,
                                    rua = endereco.rua,
                                    cidade = endereco.cidade,
                                    bairro = endereco.bairro,
                                    uf = endereco.uf,
                                    descricao = descricaoState
                                )
                                scope.launch {
                                    ocorridoRepository.salvar(novoOcorrido)
                                    navController.navigate("reports")
                                }
                            }
                        }

                        override fun onFailure(call: Call<Endereco>, t: Throwable) {
                            Toast.makeText(context, "Erro ao buscar CEP", Toast.LENGTH_SHORT).show()
                        }
                    })
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF0D47A1))
            ) {
                Text(text = "Salvar Report")
            }

        }
    }
}




@Composable
fun CardEndereco(endereco: Endereco) {
    Spacer(modifier = Modifier.height(16.dp))
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 4.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Text(text = "ALERTA !!", fontSize = 24.sp, color = Color.Red, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(5.dp))
            Text(text = "CEP: ${endereco.cep}")
            Text(text = "Rua: ${endereco.rua}")
            Text(text = "Cidade: ${endereco.cidade}")
            Text(text = "Bairro: ${endereco.bairro}")
            Text(text = "UF: ${endereco.uf}")
            Text(text = "Descrição: ${endereco.descricao}")
        }
    }
}


fun Ocorrido.toEndereco(): Endereco {
    return Endereco(
        cep = this.cep,
        rua = this.rua,
        cidade = this.cidade,
        bairro = this.bairro,
        uf = this.uf,
        descricao = this.descricao
    )
}

