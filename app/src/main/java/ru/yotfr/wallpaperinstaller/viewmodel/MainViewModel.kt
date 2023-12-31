package ru.yotfr.wallpaperinstaller.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import ru.yotfr.settings.usecase.GetThemeUseCase
import ru.yotfr.wallpaperinstaller.state.MainActivityState
import ru.yotfr.wallpaperinstaller.util.map
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getThemeUseCase: GetThemeUseCase
) : ViewModel() {

    private val _state = mutableStateOf(MainActivityState())
    val state: State<MainActivityState> = _state

    init {
        checkSettings()
    }
    private fun checkSettings() {
        viewModelScope.launch {
            getThemeUseCase().collectLatest { theme ->
                _state.value = _state.value.copy(
                    theme = theme.map()
                )
            }
        }
    }
}