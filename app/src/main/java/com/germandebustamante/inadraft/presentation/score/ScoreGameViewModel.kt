package com.germandebustamante.inadraft.presentation.score

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.germandebustamante.inadraft.domain.game.usecase.InsertFinishedGameUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ScoreGameViewModel @Inject constructor(
    private val insertFinishedGameUseCase: InsertFinishedGameUseCase,
    private val savedStateHandle: SavedStateHandle,
) : ViewModel() {

    //region livedata
    private val _operationSuccess = MutableLiveData<Unit>()
    val operationSuccess: LiveData<Unit> get() = _operationSuccess
    //endregion

    //region public methods
    fun insertGame(userNickname: String) {
        savedStateHandle.get<Int>("totalPunctuation")?.let {
            viewModelScope.launch {
                insertFinishedGameUseCase(it, userNickname)
                    .collect {
                        _operationSuccess.postValue(Unit)
                    }
            }
        }
    }
    //endregion

}