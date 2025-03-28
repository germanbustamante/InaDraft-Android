package com.germandebustamante.inadraft.presentation.information.player

import androidx.core.view.isVisible
import com.germandebustamante.inadraft.databinding.FragmentPlayerInfoListBinding
import com.germandebustamante.inadraft.domain.player.model.FullInfoPlayer

//region public methods
fun FragmentPlayerInfoListBinding.setupRecyclerView(adapter: PlayerDetailAdapter) {
    playerInfoListFragmentSlideListOfPlayers.adapter = adapter
}

fun FragmentPlayerInfoListBinding.onPlayerListChanged(
    players: List<FullInfoPlayer>,
    adapter: PlayerDetailAdapter,
) {
    playerInfoListFragmentSwipeRefreshLayout.isRefreshing = false
    adapter.submitList(players)
}

fun FragmentPlayerInfoListBinding.setupListeners(viewModel: PlayerInfoListViewModel) {
    playerInfoListFragmentSwipeRefreshLayout.setOnRefreshListener { viewModel.loadPlayerByTeam() }
}

fun FragmentPlayerInfoListBinding.onProgressVisibleChanged(visibility: Boolean) {
    if (visibility) {
        playerInfoListFragmentLoading.root.startShimmer()
    } else {
        playerInfoListFragmentLoading.root.stopShimmer()
    }
    playerInfoListFragmentLoading.root.isVisible = visibility
    playerInfoListFragmentSlideListOfPlayers.isVisible = !visibility
}
//endregion

