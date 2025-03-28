package com.germandebustamante.inadraft.presentation.ranking

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.germandebustamante.inadraft.domain.game.model.GameBO
import com.germandebustamante.inadraft.domain.game.usecase.GetBestGamesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RankingViewModel @Inject constructor(
    private val getBestGamesUseCase: GetBestGamesUseCase,
) : ViewModel() {

    //region live data
    private val _games = MutableLiveData<List<GameBO>>()
    val games: LiveData<List<GameBO>> get() = _games
    //endregion

    //region public functions
    fun loadBestGames() {
        viewModelScope.launch {
            getBestGamesUseCase().collect {
                _games.postValue(it)
            }
        }
    }
    //endregion
}
