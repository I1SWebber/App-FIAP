package br.com.fiap.app.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import br.com.fiap.app.model.Ocorrido

@Dao
interface OcorridoDao {

    @Insert
    suspend fun salvar(ocorrido: Ocorrido): Long


    @Query("SELECT * FROM tbl_ocorrido ORDER BY cep ASC")
    suspend fun listarOcorridos(): List<Ocorrido>
}