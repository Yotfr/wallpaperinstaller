package ru.yotfr.shared

import ru.yotfr.database.entity.WallpaperEntity
import ru.yotfr.network.model.WallpaperResponse
import ru.yotfr.shared.model.Wallpaper

fun WallpaperResponse.mapDomain(isFavorite: Boolean = false) : Wallpaper {
    return Wallpaper(
        id = id,
        url = url,
        previewUrl = previewUrl,
        isFavorite = isFavorite,
        previewWidth = previewWidth,
        previewHeight = previewHeight,
        aspectRatio = previewWidth.toFloat() / previewHeight
    )
}

fun WallpaperEntity.mapDomain(): Wallpaper {
    return Wallpaper(
        id = id,
        url = url,
        previewUrl = previewUrl,
        isFavorite = isFavorite,
        previewWidth = previewWidth,
        previewHeight = previewHeight,
        aspectRatio = previewWidth.toFloat() / previewHeight
    )
}

fun Wallpaper.mapEntity(): WallpaperEntity {
    return WallpaperEntity(
        id = id,
        url = url,
        previewUrl = previewUrl,
        isFavorite = isFavorite,
        previewWidth = previewWidth,
        previewHeight = previewHeight
    )
}