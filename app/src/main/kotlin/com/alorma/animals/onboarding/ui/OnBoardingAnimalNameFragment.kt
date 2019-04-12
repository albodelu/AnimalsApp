package com.alorma.animals.onboarding.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.alorma.animals.R
import com.alorma.animals.onboarding.presentation.loadOnBoardingNameModule
import kotlinx.android.synthetic.main.onboarding_animal_name_fragment.*

class OnBoardingAnimalNameFragment : Fragment() {

    lateinit var onNameListener: (String) -> Unit

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        loadOnBoardingNameModule()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.onboarding_animal_name_fragment, null, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        animalNameButton.setOnClickListener {
            animalNameInput?.editText?.text?.toString()?.let { name ->
                onNameListener(name)
            }
        }
    }
}