package com.wenyang.androidbaseprojectmodule.utility.helper

import android.app.Application
import android.net.Uri
import android.os.Environment
import com.wenyang.androidbaseprojectmodule.utility.extension.toFile
import com.wenyang.androidbaseprojectmodule.utility.extension.toUri
import java.io.File

/**
 * Created by wenyang on 9/3/18.
 */

abstract class BaseDirectoryHelper constructor(val application: Application) {

    fun generateExternalDocumentsDirectory() : Uri {
        return Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS).toUri()
    }

    fun generateExternalDocumentsFileDirectory(fileNameResId: Int) : Uri{
        val documentsDirectoryFile = generateExternalDocumentsDirectory().toFile()

        val fileName = application.getString(fileNameResId)

        return File(documentsDirectoryFile, fileName).toUri()
    }

    fun generateExternalDocumentsFileDirectory(fileName: String) : Uri{
        val documentsDirectoryFile = generateExternalDocumentsDirectory().toFile()

        return File(documentsDirectoryFile, fileName).toUri()
    }

    fun generateFilesDir() : Uri {
        return application.filesDir.toUri()
    }

    fun generateCacheDir() : Uri {
        return application.cacheDir.toUri()
    }

    fun generateCacheDownloadDirectoryWithDownloadUrl(downloadUrl: String) : Uri {

        val fileName = downloadUrl.substringAfterLast("/").trim()

        fileName.replace("/","")

        val cacheDirectory = generateCacheDownloadDirectory(fileName).buildUpon()

        return cacheDirectory.build()
    }
    fun generateCacheDownloadDirectory(fileName: String) : Uri {

        val cacheDirectory = generateCacheDir().buildUpon().appendPath(fileName)

        return cacheDirectory.build()
    }

}