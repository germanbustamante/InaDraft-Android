package com.germandebustamante.inadraft.presentation.information.player

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.germandebustamante.inadraft.databinding.FragmentPlayerInfoListBinding
import com.germandebustamante.inadraft.ui.view.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PlayerInfoListFragment : BaseFragment<FragmentPlayerInfoListBinding>() {

    //region class attributes
    private val viewModel: PlayerInfoListViewModel by viewModels()
    private var adapter : PlayerDetailAdapter? = null
    //endregion

    //region override methods
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = inflateViewBinding(inflater, container)
        binding?.apply {
            playerInfoListFragmentLoading.root.startShimmer()
            setupDrawerWithFragmentToolbar(playerInfoListFragmentToolbarTop)
            adapter = PlayerDetailAdapter().also { setupRecyclerView(it) }
            setupListeners(viewModel)
        }
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupObservers()
        viewModel.loadPlayerByTeam()
    }

    override fun inflateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentPlayerInfoListBinding =
        FragmentPlayerInfoListBinding.inflate(inflater, container, false)

    override fun onDestroyView() {
        super.onDestroyView()
        adapter = null
        binding = null
    }
    //endregion

    //region private methods
    private fun setupObservers(){
        viewModel.playerList.observe(viewLifecycleOwner) {
            adapter?.let { adapter -> binding?.onPlayerListChanged(it, adapter) }
        }
        viewModel.progressVisible.observe(viewLifecycleOwner) { binding?.onProgressVisibleChanged(it) }
    }
    //endregion
}



