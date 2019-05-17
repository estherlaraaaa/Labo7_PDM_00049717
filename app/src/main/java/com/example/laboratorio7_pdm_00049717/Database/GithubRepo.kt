package com.example.laboratorio7_pdm_00049717.Database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "repos")
data class GithubRepo (

    //aca si le quiero poner nombre a la columna
   // @ColumnInfo(name = "s_name")
    val name: String){
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
}