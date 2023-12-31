package ru.yotfr.favoritewallpapers.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import ru.yotfr.favoritewallpapers.event.FavoriteWallpapersEvent
import ru.yotfr.favoritewallpapers.usecase.ChangeWallpaperFavoriteStatusUseCase
import ru.yotfr.favoritewallpapers.usecase.GetFavoriteWallpapersUseCase
import ru.yotfr.shared.model.Wallpaper
import javax.inject.Inject

@HiltViewModel
internal class FavoriteWallpapersViewModel @Inject constructor(
    private val getFavoriteWallpapersUseCase: GetFavoriteWallpapersUseCase,
    private val changeWallpaperFavoriteStatusUseCase: ChangeWallpaperFavoriteStatusUseCase
) : ViewModel() {

    private val _favoriteWallpapers = MutableStateFlow<List<Wallpaper>>(emptyList())
    val favoriteWallpapers = _favoriteWallpapers.asStateFlow()

    init {
        viewModelScope.launch {
            getFavoriteWallpapersUseCase().collectLatest { wallpapers ->
                _favoriteWallpapers.value = wallpapers
            }
        }
    }

    fun onEvent(event: FavoriteWallpapersEvent) {
        when(event) {
            is FavoriteWallpapersEvent.ChangeFavorite -> {
                changeFavorite(event.wallpaper)
            }
        }
    }

    private fun changeFavorite(wallpaper: Wallpaper) {
        viewModelScope.launch {
            changeWallpaperFavoriteStatusUseCase(wallpaper)
        }
    }

}