package com.germandebustamante.inadraft.presentation.formation.inner

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.germandebustamante.inadraft.domain.player.model.FullInfoPlayer
import com.germandebustamante.inadraft.domain.player.usecase.GetPlayerByIdUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GameViewModel @Inject constructor(
    private val getPlayerByIdUseCase: GetPlayerByIdUseCase,
) : ViewModel() {

    //region livedata
    private val _playersDraft: MutableLiveData<MutableMap<Int, FullInfoPlayer>> = MutableLiveData(mutableMapOf())
    val playersDraft: LiveData<MutableMap<Int, FullInfoPlayer>> get() = _playersDraft
    //endregion

    //region public methods
    fun loadPlayer(playerCardId: Int, playerId: String) {
        viewModelScope.launch {
            getPlayerByIdUseCase(playerId).catch {
                it.printStackTrace()
                Log.e(TAG, "Error loading player: $it")
            }.collect {
                val playersMapDraft = _playersDraft.value ?: mutableMapOf()
                playersMapDraft[playerCardId] = it
                _playersDraft.postValue(playersMapDraft)
            }
        }
    }
    //endregion

    companion object {
        private const val TAG = "GameViewModel"
    }
}