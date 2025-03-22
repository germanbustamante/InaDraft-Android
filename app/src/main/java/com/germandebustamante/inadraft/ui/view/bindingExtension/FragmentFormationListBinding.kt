package com.germandebustamante.inadraft.ui.view.bindingExtension

import androidx.navigation.findNavController
import com.germandebustamante.inadraft.ui.adapter.FormationAdapter
import com.germandebustamante.inadraft.presentation.formation.Formation442Fragment.Companion.FORMATION_4_4_2
import com.germandebustamante.inadraft.databinding.FragmentFormationListBinding
import com.germandebustamante.inadraft.domain.formation.model.FormationBO
import com.germandebustamante.inadraft.ui.view.fragment.FormationListFragmentDirections

//region public methods
fun FragmentFormationListBinding.onFormationListChanged(
    formations: List<FormationBO>,
    adapter: FormationAdapter,
) {
    adapter.submitList(formations)
}

fun FragmentFormationListBinding.setupRecyclerView(adapter: FormationAdapter) {
    formationListFragmentListOfFormations.adapter = adapter
}

fun FragmentFormationListBinding.onFormationSelected(formation: FormationBO) {
    root.findNavController().navigate(
        when (formation.name) {
            FORMATION_4_4_2 -> FormationListFragmentDirections.actionFormationListFragmentToFormation442Fragment(
                formation.id)
            else -> FormationListFragmentDirections.actionFormationListFragmentToFormation442Fragment(
                formation.id)
        })
}

//endregion