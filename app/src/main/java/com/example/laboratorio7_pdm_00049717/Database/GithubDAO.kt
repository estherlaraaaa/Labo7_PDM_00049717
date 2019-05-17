package com.example.laboratorio7_pdm_00049717.Database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface GithubDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    //suspend para decir que es asincrona
    suspend fun insert(repo: GithubRepo)

    @Query("SELECT * FROM repos")
    fun getAllRepos():LiveData<List<GithubRepo>>

    @Query("DELETE FROM repos")
    fun nukeTable()


}