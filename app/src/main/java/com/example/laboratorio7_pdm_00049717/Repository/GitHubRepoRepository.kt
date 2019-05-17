package com.example.laboratorio7_pdm_00049717.Repository

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.example.laboratorio7_pdm_00049717.Database.GithubDAO
import com.example.laboratorio7_pdm_00049717.Database.GithubRepo

class GitHubRepoRepository (private val repoDao: GithubDAO){

    @WorkerThread
    suspend fun insert(repo: GithubRepo){
        repoDao.insert(repo)
    }

    fun getAll():LiveData<List<GithubRepo>> = repoDao.getAllRepos()

    fun nuke() = repoDao.nukeTable()


}