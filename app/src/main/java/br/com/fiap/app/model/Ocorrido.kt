package br.com.fiap.app.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tbl_ocorrido")
data class Ocorrido(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val cep: String,
    val rua: String,
    val cidade: String,
    val bairro: String,
    val uf: String,
    val descricao: String
)
