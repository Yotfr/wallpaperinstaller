package ru.yotfr.savedwallpapers.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.core.net.toUri
import coil.compose.AsyncImage
import ru.yotfr.designsystem.theme.WallpaperTheme
import ru.yotfr.shared.model.DownloadedImages

@Composable
internal fun SavedWallpaperItem(
    downloadedImage: DownloadedImages,
    onClick: (String) -> Unit
) {
    Surface(
        shape = WallpaperTheme.shape.default,
        color = MaterialTheme.colorScheme.surface
    ) {
        Box(
            modifier = Modifier
                .clickable {
                    onClick(downloadedImage.modelId)
                }
        ) {
            AsyncImage(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = WallpaperTheme.extraColors.placeHolderColor),
                model = downloadedImage.uri.toUri(),
                contentDescription = null,
                contentScale = ContentScale.FillWidth,
            )
        }
    }
}