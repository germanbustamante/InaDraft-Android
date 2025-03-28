package com.germandebustamante.inadraft.presentation.playerSelection

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.germandebustamante.inadraft.domain.player.model.FullInfoPlayer
import com.germandebustamante.inadraft.domain.player.usecase.GetRandomPlayersByPositionUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PlayerSelectionViewModel @Inject constructor(
    private val getRandomPlayersByPositionUseCase: GetRandomPlayersByPositionUseCase,
    private val savedStateHandle: SavedStateHandle,
) : ViewModel() {

    //region livedata
    private val _randomPlayers = MutableLiveData<List<FullInfoPlayer>>()
    val randomPlayers: LiveData<List<FullInfoPlayer>> get() = _randomPlayers
    //endregion

    //region public functions
    fun loadRandomPlayers() {
        savedStateHandle.get<String>(ARGUMENT_KEY_PLAYER_POSITION_ID)?.let {
            viewModelScope.launch {
                getRandomPlayersByPositionUseCase(it).collect {
                    _randomPlayers.postValue(it)
                }
            }
        }
    }
    //endregion

    companion object {
        private const val ARGUMENT_KEY_PLAYER_POSITION_ID = "playerPositionId"
    }
}