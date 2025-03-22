package com.germandebustamante.inadraft.ui.view.bindingExtension

import androidx.core.view.isVisible
import androidx.navigation.findNavController
import com.germandebustamante.inadraft.ui.adapter.TeamAdapter
import com.germandebustamante.inadraft.ui.viewmodel.TeamInfoListVM
import com.germandebustamante.inadraft.databinding.FragmentTeamInfoListBinding
import com.germandebustamante.inadraft.domain.team.model.TeamBO
import com.germandebustamante.inadraft.ui.view.fragment.TeamInfoListFragmentDirections

//region public methods
fun FragmentTeamInfoListBinding.setupRecyclerView(adapter: TeamAdapter) {
    infoTeamFragmentListOfTeams.adapter = adapter
}

fun FragmentTeamInfoListBinding.onTeamClicked(teamSelected: TeamBO) {
    root.findNavController().navigate(
        TeamInfoListFragmentDirections.actionInfoTeamFragmentToPlayerListFragment(teamSelected.id)
    )
}

fun FragmentTeamInfoListBinding.setupListeners(viewModel : TeamInfoListVM){
    infoTeamFragmentSwipeRefreshLayout.setOnRefreshListener { onTeamInfoListRefreshed(viewModel) }
}

fun FragmentTeamInfoListBinding.onTeamListChanged(
    teamList: List<TeamBO>,
    adapter: TeamAdapter
) {
    infoTeamFragmentSwipeRefreshLayout.isRefreshing = false
    adapter.submitList(teamList)
}

fun FragmentTeamInfoListBinding.onProgressVisibleChanged(visibility: Boolean) {
    if (visibility){
        teamInfoListFragmentLoading.root.startShimmer()
    }else{
        teamInfoListFragmentLoading.root.stopShimmer()
    }
    teamInfoListFragmentLoading.root.isVisible = visibility
    infoTeamFragmentListOfTeams.isVisible = !visibility
}
//endregion

//region private methods
private fun FragmentTeamInfoListBinding.onTeamInfoListRefreshed(viewModel : TeamInfoListVM) {
    viewModel.loadTeamList()
}
//endregion
