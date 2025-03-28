package com.germandebustamante.inadraft.presentation.formation.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.germandebustamante.inadraft.domain.formation.model.FormationBO
import com.germandebustamante.inadraft.domain.formation.usecase.GetFormationsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FormationListViewModel @Inject constructor(
    private val getFormationsUseCase: GetFormationsUseCase,
) : ViewModel() {

    //region livedata
    private val _formations = MutableStateFlow<List<FormationBO>>(emptyList())
    val formations: StateFlow<List<FormationBO>> = _formations.asStateFlow()
    //endregion

    //region public functions
    fun loadFormations() {
        viewModelScope.launch() {
            getFormationsUseCase().collect { formations ->
                _formations.value = formations
            }
        }
    }
    //endregion
}