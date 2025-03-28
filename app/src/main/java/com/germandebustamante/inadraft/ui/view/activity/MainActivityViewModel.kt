package com.germandebustamante.inadraft.ui.view.activity

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.germandebustamante.inadraft.domain.PopulateDatabaseUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val populateDatabaseUseCase: PopulateDatabaseUseCase,
) : ViewModel() {

    //region live data
    private val _isLoading = MutableStateFlow(true)
    val isLoading = _isLoading.asStateFlow()
    //endregion

    //region public methods
    init {
        viewModelScope.launch {
            delay(500)
            _isLoading.value = false
        }
    }
    //endregion
}