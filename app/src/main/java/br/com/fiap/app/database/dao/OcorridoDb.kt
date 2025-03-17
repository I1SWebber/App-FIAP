package br.com.fiap.app.database.dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.com.fiap.app.model.Ocorrido

@Database(entities = [Ocorrido::class], version = 2)
abstract class OcorridoDb : RoomDatabase() {

    abstract fun ocorridoDao(): OcorridoDao

    companion object {
        @Volatile
        private var INSTANCE: OcorridoDb? = null

        fun getDatabase(context: Context): OcorridoDb {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    OcorridoDb::class.java,
                    "ocorrido_db"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}