package com.example.laboratorio7_pdm_00049717

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.laboratorio7_pdm_00049717.Database.GithubRepo
import com.example.laboratorio7_pdm_00049717.ViewModels.GitHubRepoViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel= ViewModelProviders.of(this).get(GitHubRepoViewModel::class.java)

        btn_add.setOnClickListener{
            val name = et_name.text.toString()
            if (name.isNotEmpty() && name.isNotBlank()){
                viewModel.insert(GithubRepo(name))
            }
        }

        //observa lo que haya puesto en los "<<>>" de la lista
        viewModel.getAll().observe(this, Observer {repos->
            Log.d("lista de repos", "_________________________________")
            for (repo in repos){
                Log.d("Lista de repos", repo.name)
            }
        })
    }
}
