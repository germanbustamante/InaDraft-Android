package com.germandebustamante.inadraft.presentation.home

import androidx.navigation.findNavController
import com.germandebustamante.inadraft.R
import com.germandebustamante.inadraft.databinding.FragmentHomeBinding

//region public methods
fun FragmentHomeBinding.setListeners(){
    homeFragmentBtnPlay.setOnClickListener { root.findNavController().navigate(R.id.action_homeFragment_to_formationListFragment) }
}
//endregion