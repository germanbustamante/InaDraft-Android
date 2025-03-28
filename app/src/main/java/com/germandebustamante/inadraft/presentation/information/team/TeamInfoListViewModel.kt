package com.germandebustamante.inadraft.presentation.information.team

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.germandebustamante.inadraft.domain.team.model.TeamBO
import com.germandebustamante.inadraft.domain.team.usecase.GetTeamsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TeamInfoListViewModel @Inject constructor(
    private val getTeamsUseCase: GetTeamsUseCase,

    ) : ViewModel() {

    //region live data
    private val _teamList = MutableLiveData<List<TeamBO>>()
    val teamList: LiveData<List<TeamBO>> get() = _teamList

    private val _progressVisible = MutableLiveData<Boolean>()
    val progressVisible: LiveData<Boolean> get() = _progressVisible
    //endregion

    //region public functions
    fun loadTeamList() {
        viewModelScope.launch {
            _progressVisible.postValue(true)
            getTeamsUseCase().collect {
                _teamList.postValue(it)
                _progressVisible.postValue(false)
            }
        }
    }
    //endregion

}