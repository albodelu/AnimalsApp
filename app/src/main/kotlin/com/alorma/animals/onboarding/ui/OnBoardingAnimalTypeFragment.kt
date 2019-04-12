package com.alorma.animals.onboarding.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.afollestad.materialdialogs.MaterialDialog
import com.afollestad.materialdialogs.lifecycle.lifecycleOwner
import com.afollestad.materialdialogs.list.listItemsSingleChoice
import com.alorma.animals.R
import com.alorma.animals.domain.model.FormField
import com.alorma.animals.onboarding.presentation.SelectTypeViewModel
import com.alorma.animals.onboarding.presentation.loadOnBoardingSelectTypeModule
import com.google.android.material.textfield.TextInputLayout
import kotlinx.android.synthetic.main.onboarding_animal_type_fragment.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class OnBoardingAnimalTypeFragment : Fragment() {

    lateinit var onSelectedTypeListener : (FormField.IdValue) -> Unit

    private val selectTypeViewModel: SelectTypeViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        loadOnBoardingSelectTypeModule()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.onboarding_animal_type_fragment, null, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        animalType.onActionListener = {
            selectTypeViewModel.onRequest {
                showItems(it) { idValue ->
                    view.findViewById<TextInputLayout>(R.id.animalTypeInput)
                        ?.editText
                        ?.setText(idValue.name)

                    onSelectedTypeListener(idValue)
                }
            }
        }
    }

    private fun showItems(values: List<FormField.IdValue>, block: (FormField.IdValue) -> Unit) {
        MaterialDialog(requireContext()).show {
            title(R.string.animal_type_dialog_title)
            lifecycleOwner(viewLifecycleOwner)
            val names = values.map { it.name }
            listItemsSingleChoice(items = names) { _, index, _ ->
                block(values[index])
            }
        }
    }
}