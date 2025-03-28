package com.germandebustamante.inadraft.presentation.information.player

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.germandebustamante.inadraft.domain.player.model.FullInfoPlayer
import com.germandebustamante.inadraft.domain.player.model.PlayerBO
import com.germandebustamante.inadraft.domain.player.usecase.GetPlayersByTeamUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PlayerInfoListViewModel @Inject constructor(
    private val getPlayersByTeamUseCase: GetPlayersByTeamUseCase,
    private val savedStateHandle: SavedStateHandle,
) : ViewModel() {

    //region live data
    private val _playerList = MutableLiveData<List<FullInfoPlayer>>()
    val playerList: LiveData<List<FullInfoPlayer>> get() = _playerList

    private val _progressVisible = MutableLiveData<Boolean>()
    val progressVisible: LiveData<Boolean> get() = _progressVisible
    //endregion

    //region public methods
    fun loadPlayerByTeam() {
        savedStateHandle.get<Int>(ARGUMENT_KEY_TEAM_ID)?.let { teamId ->
            viewModelScope.launch {
                _progressVisible.postValue(true)
                getPlayersByTeamUseCase(teamId).collect {
                    _playerList.postValue(it)
                    _progressVisible.postValue(false)
                }
            }
        }
    }
    //endregion

    companion object {
        private const val ARGUMENT_KEY_TEAM_ID = "teamId"
    }
}