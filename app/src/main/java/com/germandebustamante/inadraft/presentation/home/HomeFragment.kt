package com.germandebustamante.inadraft.presentation.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.germandebustamante.inadraft.ui.view.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import com.germandebustamante.inadraft.databinding.FragmentHomeBinding

/**
 * Pantalla de inicio en la que se muestra el titulo de la App y un botón para comenzar a jugar
 */
@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    //region override methods
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = inflateViewBinding(inflater, container)
        binding?.apply {
            setupDrawerWithFragmentToolbar(homeFragmentToolbarTop)
            setListeners()
        }
        return binding?.root
    }

    override fun inflateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentHomeBinding = FragmentHomeBinding.inflate(inflater, container, false)
    //endregion
}