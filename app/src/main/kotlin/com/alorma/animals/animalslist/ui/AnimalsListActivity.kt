package com.alorma.animals.animalslist.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.alorma.animals.R
import com.alorma.animals.animalslist.presentation.AnimalsListViewModel
import com.alorma.animals.animalslist.presentation.loadAnimalsModule
import kotlinx.android.synthetic.main.animals_list_activity.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class AnimalsListActivity : AppCompatActivity() {

    private val animalsListViewModel: AnimalsListViewModel by viewModel()

    private val adapter: AnimalsAdapter = AnimalsAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.animals_list_activity)
        loadAnimalsModule()

        animalsList.layoutManager = LinearLayoutManager(this)
        animalsList.adapter = adapter

        animalsListViewModel.animals.observe(this, Observer {
            adapter.submitList(it)
        })
        animalsListViewModel.onInit()
    }
}