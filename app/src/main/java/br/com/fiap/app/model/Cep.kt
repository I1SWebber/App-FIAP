package br.com.fiap.app

import com.google.gson.annotations.SerializedName

data class Endereco(
    val cep: String = "",
    @SerializedName("logradouro") val rua: String = "",
    @SerializedName("localidade") val cidade: String = "",
    val bairro: String = "",
    val uf: String = "",
    var descricao: String = ""
)