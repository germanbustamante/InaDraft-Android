package com.germandebustamante.inadraft.presentation.formation.list

import androidx.navigation.findNavController
import com.germandebustamante.inadraft.databinding.FragmentFormationListBinding
import com.germandebustamante.inadraft.domain.formation.model.FormationBO
import com.germandebustamante.inadraft.presentation.formation.inner.Formation442Fragment.Companion.FORMATION_4_4_2_ID

//region public methods
fun FragmentFormationListBinding.setupRecyclerView(adapter: FormationAdapter) {
    formationListFragmentListOfFormations.adapter = adapter
}

fun FragmentFormationListBinding.onFormationSelected(formation: FormationBO) {
    root.findNavController().navigate(
        when (formation.name) {
            FORMATION_4_4_2_ID -> FormationListFragmentDirections.actionFormationListFragmentToFormation442Fragment(
                formation.id
            )
            else -> FormationListFragmentDirections.actionFormationListFragmentToFormation442Fragment(formation.id)
        }
    )
}
//endregion