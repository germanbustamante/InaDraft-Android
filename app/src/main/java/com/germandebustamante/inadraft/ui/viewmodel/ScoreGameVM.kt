package com.germandebustamante.inadraft.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import com.germandebustamante.inadraft.domain.game.model.GameBO
import com.germandebustamante.inadraft.domain.game.usecase.InsertFinishedGameUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * ViewModel del dialog de elegir jugador
 * @property _operationSuccess LiveData observable booleano informando de si se ha añadido correctamente la partida
 */
@HiltViewModel
class ScoreGameVM @Inject constructor(
    private val insertFinishedGameUseCase: InsertFinishedGameUseCase
): ViewModel() {

    //region livedata
    private val _operationSuccess = MutableLiveData<Boolean>()
    val operationSuccess: LiveData<Boolean> get() = _operationSuccess
    //endregion

    //region public methods
    fun insertGame(game : GameBO) {
        viewModelScope.launch(Dispatchers.IO) {
            _operationSuccess.postValue(insertFinishedGameUseCase.invoke(game))
        }
    }
    //endregion

}