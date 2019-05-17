package com.example.laboratorio7_pdm_00049717.ViewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.laboratorio7_pdm_00049717.Database.GithubRepo
import com.example.laboratorio7_pdm_00049717.Database.RoomDB
import com.example.laboratorio7_pdm_00049717.Repository.GitHubRepoRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class GitHubRepoViewModel (app: Application): AndroidViewModel(app){

    private val repository: GitHubRepoRepository

    //el init es el constructror de la clase, por eso es que en el modelo el id esta afuera
    init {
        val repoDao = RoomDB.getInstace(app).repoDao()
        repository = GitHubRepoRepository(repoDao)
    }

    //aca ya no se pone suspend, porque suspend es solo cuando no se usa en el launch, en este si ya lo uso
    fun insert(repo: GithubRepo) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(repo)
    }

    fun getAll(): LiveData<List<GithubRepo>> = repository.getAll()

    fun nukeAll() = repository.nuke()

}