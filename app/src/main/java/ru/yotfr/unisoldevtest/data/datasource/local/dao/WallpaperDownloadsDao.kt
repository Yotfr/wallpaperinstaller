package ru.yotfr.unisoldevtest.data.datasource.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import ru.yotfr.unisoldevtest.data.datasource.local.entity.WallpaperDownloadsEntity

@Dao
interface WallpaperDownloadsDao {

    @Insert(entity = WallpaperDownloadsEntity::class)
    suspend fun addNewDownload(download: WallpaperDownloadsEntity)

    @Insert(entity = WallpaperDownloadsEntity::class)
    suspend fun deleteDownload(download: WallpaperDownloadsEntity)

    @Query("SELECT * FROM wallpaper_downloads WHERE downloadId = :downloadId")
    suspend fun getDownloadById(downloadId: Long): WallpaperDownloadsEntity


}