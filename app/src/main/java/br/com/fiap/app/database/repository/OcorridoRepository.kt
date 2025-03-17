package br.com.fiap.app.database.repository

import android.content.Context
import br.com.fiap.app.database.dao.OcorridoDb
import br.com.fiap.app.model.Ocorrido
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class OcorridoRepository(context: Context) {

    private val db = OcorridoDb.getDatabase(context).ocorridoDao()

    suspend fun salvar(ocorrido: Ocorrido): Long {
        return withContext(Dispatchers.IO) {
            db.salvar(ocorrido)
        }
    }

    suspend fun listarOcorridos(): List<Ocorrido> {
        return withContext(Dispatchers.IO) {
            db.listarOcorridos()
        }
    }
}

