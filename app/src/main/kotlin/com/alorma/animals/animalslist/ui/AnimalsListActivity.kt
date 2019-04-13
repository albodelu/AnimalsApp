package com.alorma.animals.animalslist.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.alorma.animals.animalslist.presentation.AnimalsListViewModel
import com.alorma.animals.animalslist.presentation.loadAnimalsModule
import org.koin.androidx.viewmodel.ext.android.viewModel

class AnimalsListActivity: AppCompatActivity() {

    private val animalsListViewModel: AnimalsListViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loadAnimalsModule()

        animalsListViewModel.onInit()
    }
}