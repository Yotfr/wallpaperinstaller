package com.example.categories.screen

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import coil.compose.AsyncImage
import coil.request.CachePolicy
import coil.request.ImageRequest
import ru.yotfr.shared.model.Category
import ru.yotfr.shared.model.CategoryModel
import ru.yotfr.shared.mapper.displayName
import ru.yotfr.designsystem.theme.WallpaperTheme

@Composable
internal fun CategoryItem(
    categoryModel: CategoryModel,
    onClick: (Category) -> Unit,
    context: Context
) {
    Surface(
        shape = WallpaperTheme.shape.default
    ) {
        Box(
            modifier = Modifier
                .clickable {
                    onClick(categoryModel.category)
                }
        ) {
            AsyncImage(
                modifier = Modifier
                    .fillMaxSize()
                    .aspectRatio(categoryModel.aspectRatio)
                    .background(color = WallpaperTheme.extraColors.placeHolderColor)
                    .drawWithCache {
                        onDrawWithContent {
                            drawContent()
                            drawRect(
                                brush = Brush.verticalGradient(
                                    colors = listOf(
                                        Color.Transparent,
                                        Color.Black
                                    ),
                                    startY = size.height / 3,
                                    endY = size.height
                                ),
                                blendMode = BlendMode.Multiply
                            )
                        }
                    },
                model = ImageRequest.Builder(context.applicationContext)
                    .data(categoryModel.previewUrl)
                    .crossfade(true)
                    .diskCacheKey(categoryModel.previewUrl)
                    .diskCachePolicy(CachePolicy.ENABLED)
                    .build(),
                contentDescription = null,
                contentScale = ContentScale.FillWidth,
            )
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .align(Alignment.BottomCenter)
                    .padding(
                        start = WallpaperTheme.spacing.small,
                        end = WallpaperTheme.spacing.small,
                        bottom = WallpaperTheme.spacing.small
                    ),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Bottom
            ) {
                Text(
                    text = categoryModel.category.displayName(),
                    color = WallpaperTheme.extraColors.onWallpaperText,
                    style = WallpaperTheme.typography.body
                )
                Text(
                    text = categoryModel.wallpapersCount.toString(),
                    color = WallpaperTheme.extraColors.onWallpaperText,
                    style = WallpaperTheme.typography.body
                )
            }
        }
    }
}