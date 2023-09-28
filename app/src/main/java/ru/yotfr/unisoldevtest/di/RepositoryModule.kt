package ru.yotfr.unisoldevtest.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.yotfr.downloader.repository.WallpaperDownloadsRepositoryImpl
import ru.yotfr.downloader.repository.WallpaperDownloadsRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {
    @Binds
    @Singleton
    fun bindWallpaperRepository(
        wallpaperRepositoryImpl: WallpaperRepositoryImpl
    ): WallpaperRepository

    @Binds
    @Singleton
    fun bindWallpaperDownloadsRepository(
        wallpaperDownloadsRepositoryImpl: WallpaperDownloadsRepositoryImpl
    ): WallpaperDownloadsRepository
}