package com.germandebustamante.inadraft.presentation.information.team

import androidx.core.view.isVisible
import androidx.navigation.findNavController
import com.germandebustamante.inadraft.databinding.FragmentTeamInfoListBinding
import com.germandebustamante.inadraft.domain.team.model.TeamBO
import com.germandebustamante.inadraft.ui.adapter.TeamAdapter

//region public methods
fun FragmentTeamInfoListBinding.setupRecyclerView(adapter: TeamAdapter) {
    infoTeamFragmentListOfTeams.adapter = adapter
}

fun FragmentTeamInfoListBinding.onTeamClicked(teamSelected: TeamBO) {
    root.findNavController().navigate(
        TeamInfoListFragmentDirections.actionInfoTeamFragmentToPlayerListFragment(teamSelected.id)
    )
}

fun FragmentTeamInfoListBinding.setupListeners(viewModel: TeamInfoListViewModel) {
    infoTeamFragmentSwipeRefreshLayout.setOnRefreshListener { viewModel.loadTeamList() }
}

fun FragmentTeamInfoListBinding.onTeamListChanged(
    teamList: List<TeamBO>,
    adapter: TeamAdapter,
) {
    infoTeamFragmentSwipeRefreshLayout.isRefreshing = false
    adapter.submitList(teamList)
}

fun FragmentTeamInfoListBinding.onProgressVisibleChanged(visibility: Boolean) {
    if (visibility) {
        teamInfoListFragmentLoading.root.startShimmer()
    } else {
        teamInfoListFragmentLoading.root.stopShimmer()
    }
    teamInfoListFragmentLoading.root.isVisible = visibility
    infoTeamFragmentListOfTeams.isVisible = !visibility
}
//endregion
