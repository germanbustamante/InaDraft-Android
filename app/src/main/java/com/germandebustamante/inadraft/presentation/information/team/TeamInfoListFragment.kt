package com.germandebustamante.inadraft.presentation.information.team

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.germandebustamante.inadraft.ui.adapter.TeamAdapter
import com.germandebustamante.inadraft.ui.view.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import com.germandebustamante.inadraft.databinding.FragmentTeamInfoListBinding

@AndroidEntryPoint
class TeamInfoListFragment : BaseFragment<FragmentTeamInfoListBinding>() {

    //region class attributes
    private val viewModel: TeamInfoListViewModel by viewModels()
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
