package ru.yotfr.storageloader.storageloader

import android.content.ContentUris
import android.content.Context
import android.os.Build
import android.provider.MediaStore
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import ru.yotfr.shared.model.DownloadedImages
import ru.yotfr.shared.model.ErrorCause
import ru.yotfr.shared.model.ResponseResult

internal class StorageLoaderImpl(
    private val context: Context
) : StorageLoader {

    override suspend fun getSavedImages() = flow<ResponseResult<List<DownloadedImages>?>> {
        try {
            emit(ResponseResult.Loading())

            val collection = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                MediaStore.Images.Media.getContentUri(MediaStore.VOLUME_EXTERNAL)
            } else MediaStore.Images.Media.EXTERNAL_CONTENT_URI

            val selection =
                MediaStore.Images.ImageColumns.RELATIVE_PATH + " like ? "
            val projection = arrayOf(
                MediaStore.Images.Media._ID,
                MediaStore.Images.Media.DISPLAY_NAME,
                MediaStore.Images.Media.RELATIVE_PATH,
                MediaStore.Images.Media.BUCKET_DISPLAY_NAME,
                MediaStore.Images.Media.BUCKET_ID,
                MediaStore.MediaColumns.WIDTH
            )

            // TODO: assest module
            val selectionArgs = arrayOf("%WallpaperInstaller%")

            val sortOrder = MediaStore.MediaColumns.DATE_ADDED + " COLLATE NOCASE DESC"

            val imageList: MutableList<DownloadedImages> = mutableListOf()

            context.contentResolver?.query(
                collection,
                projection,
                selection,
                selectionArgs,
                sortOrder
            )?.use { cursor ->

                val idColumn = cursor.getColumnIndexOrThrow(MediaStore.Images.Media._ID)
                val displayNameColumn =
                    cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DISPLAY_NAME)


                while (cursor.moveToNext()) {
                    val id = cursor.getLong(idColumn)

                    /*
                    * При переименовании загруженного изображения изображение нельзя будет
                    * поместить в избранное, так как в его имени зашит айдишник, необходимый
                    * для получения изображения с API, исходя из этого переименованное изображение
                    * не будет считаться исходным в данном приложении и не будет показываться
                    * пользователю
                    */
                    val displayName = cursor.getString(displayNameColumn)
                        .substringBeforeLast(".")

                    val contentUri = ContentUris.withAppendedId(
                        MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                        id
                    )

                    imageList.add(
                        DownloadedImages(
                            id,
                            contentUri.toString(),
                            displayName
                        )
                    )

                }
                cursor.close()
            }
            emit(ResponseResult.Success(data = imageList))
        } catch (e: Exception) {
            emit(
                ResponseResult.Error(
                    cause = ErrorCause.Unknown(
                        message = e.message ?: "Something went wrong"
                    )
                )
            )
        }
    }.flowOn(Dispatchers.IO)

}