package ru.yotfr.wallpaperdownloads.downloader

import android.app.DownloadManager
import android.content.Context
import android.os.Environment
import android.webkit.MimeTypeMap
import androidx.core.net.toUri
import java.io.File

internal class DownloaderImpl(
    private val context: Context
) : Downloader {

    private val downloadManager = context.getSystemService(DownloadManager::class.java)

    /*
        setAllowedNetworkType не используется,
        так при использовании VPN
        DownloadManager не распознает NETWORK_TYPE

        Проверка на network type производится в UseCase
        */
    override fun downloadFile(
        url: String,
        fileName: String,
        pathFolderName: String
    ): Long {
        val mimeType = getMimeType(url)
        val title = fileName.plus(".").plus(mimeType.substringAfterLast("/"))
        val subPath = "$pathFolderName/$title"
        val request = DownloadManager.Request(url.toUri())
            .setMimeType(mimeType)
            .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE)
            // Загрузка невидима для других приложений
            .setVisibleInDownloadsUi(false)
            .setTitle(title)
            .setDestinationInExternalPublicDir(
                Environment.DIRECTORY_PICTURES,
                subPath
            )
        return downloadManager.enqueue(request)
    }

    override fun getDownloadStatus(downloadId: Long): Int? {
        val request = DownloadManager.Query()
            .setFilterById(downloadId)
        downloadManager.query(request).use {
            if (it.moveToFirst()) {
                return if (it.count > 0) {
                    val columnIndex = it.getColumnIndex(DownloadManager.COLUMN_STATUS)
                    val result = it.getInt(columnIndex)
                    result
                } else null
            } else {
                return null
            }
        }
    }

    override fun checkIfFileExists(
        url: String,
        fileName: String,
        pathFolderName: String
    ): Boolean {
        val mimeType = getMimeType(url)
        val title = fileName.plus(".").plus(mimeType.substringAfterLast("/"))
        // TODO: ASSETS MODULE
        val file = File(
            "${Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES)}" +
                    "/$pathFolderName/$title"
        )
        return file.exists()
    }

    private fun getMimeType(url: String): String {
        val defaultType = "image/jpeg"
        val extension = MimeTypeMap.getFileExtensionFromUrl(url)
        return extension?.let {
            MimeTypeMap.getSingleton().getMimeTypeFromExtension(extension)
        } ?: defaultType
    }
}