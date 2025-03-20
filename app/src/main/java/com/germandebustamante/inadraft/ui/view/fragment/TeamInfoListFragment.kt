package com.germandebustamante.inadraft.ui.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.germandebustamante.inadraft.ui.adapter.TeamAdapter
import com.germandebustamante.inadraft.ui.view.base.BaseFragment
import com.germandebustamante.inadraft.ui.view.bindingExtension.onProgressVisibleChanged
import com.germandebustamante.inadraft.ui.view.bindingExtension.onTeamClicked
import com.germandebustamante.inadraft.ui.view.bindingExtension.onTeamListChanged
import com.germandebustamante.inadraft.ui.view.bindingExtension.setupListeners
import com.germandebustamante.inadraft.ui.view.bindingExtension.setupRecyclerView
import com.germandebustamante.inadraft.ui.viewmodel.TeamInfoListVM
import dagger.hilt.android.AndroidEntryPoint
import com.germandebustamante.inadraft.databinding.FragmentTeamInfoListBinding

/**
 * Pantalla en la que se muestran un listado de equipos y el usuario puede clickar en una de ellos, una vez clickado, navega a
 * un Fragment dependiendo del equipo clickado para mostrar su listado de jugadores
 */
@AndroidEntryPoint
class TeamInfoListFragment : BaseFragment<FragmentTeamInfoListBinding>() {

    //region class attributes
    private val viewModel: TeamInfoListVM by viewModels()
    private var adapter: TeamAdapter? = null
    //endregion

    //region override methods
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = inflateViewBinding(inflater, container)
        binding?.apply {
            teamInfoListFragmentLoading.root.startShimmer()
            adapter = TeamAdapter { binding?.onTeamClicked(it) }.also {
                setupRecyclerView(it)
            }
            setupDrawerWithFragmentToolbar(infoTeamFragmentToolbarTop)
            setupListeners(viewModel)
        }
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupVMObservers()
        viewModel.loadTeamList()
    }

    override fun inflateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
    ): FragmentTeamInfoListBinding = FragmentTeamInfoListBinding.inflate(inflater, container, false)

    //endregion

    //region private override methods
    private fun setupVMObservers() {
        viewModel.teamList.observe(viewLifecycleOwner) {
            adapter?.let { adapter ->
                binding?.onTeamListChanged(it, adapter)
            }
        }
        viewModel.progressVisible.observe(viewLifecycleOwner) { binding?.onProgressVisibleChanged(it) }
    }
    //endregion
}
