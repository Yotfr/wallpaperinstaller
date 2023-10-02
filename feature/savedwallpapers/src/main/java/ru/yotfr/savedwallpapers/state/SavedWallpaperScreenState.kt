package ru.yotfr.savedwallpapers.state

import ru.yotfr.model.DownloadedImages

data class SavedWallpaperScreenState(
    val isLoading: Boolean = false,
    val wallpapers: List<DownloadedImages> = emptyList()
)
