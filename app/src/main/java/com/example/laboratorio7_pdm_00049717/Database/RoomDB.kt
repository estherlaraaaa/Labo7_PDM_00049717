package com.example.laboratorio7_pdm_00049717.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import java.security.AccessControlContext

@Database(entities = [GithubRepo::class], version = 1, exportSchema = false)
public abstract class RoomDB: RoomDatabase(){

    abstract fun repoDao():GithubDAO


    //para hacerlo singleton y abstracto uso el companion object
    companion object{
        private var INSTANCE: RoomDB? = null

        //en base al contexto revisa si ya existe la bd, para devolverla si existe o para crearla sino
        //el contexto que le llega es de toda la aplicacion
        fun getInstace(Appcontext: Context): RoomDB{
            val tempInstance = INSTANCE
            if(tempInstance != null) return tempInstance

            //aca creo la bd si es que no existe
            synchronized(this){
                //crea una nueva instancia de room
                //adentro de instance tenemos nuestra base de datos por medio de room
                val instance = Room
                        //le das el nombre a la base de datos
                    .databaseBuilder(Appcontext, RoomDB::class.java, "RepoDB")
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }
}