package com.wenyang.androidbaseprojectmodule.router

import android.content.ActivityNotFoundException
import android.content.Intent
import android.content.Intent.FLAG_GRANT_READ_URI_PERMISSION
import android.net.Uri
import androidx.core.content.FileProvider
import androidx.appcompat.app.AppCompatActivity
import android.webkit.MimeTypeMap
import com.wenyang.androidbaseprojectmodule.utility.extension.toFile


abstract class BaseRouter constructor(val activity: AppCompatActivity) {

    companion object {
    }

    fun navigateToGooglePlayStore() {
        val appPackageName = activity.packageName
        try {
            activity.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=$appPackageName")))
        } catch (anfe: android.content.ActivityNotFoundException) {
            activity.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=$appPackageName")))
        }

    }

    fun launchExternalWebView(url: String) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        activity.startActivity(intent)
    }

    @Throws(ActivityNotFoundException::class)
    fun navigateToExternalFileViewer(url: String) {

        val file = Uri.parse(url).toFile()
        val intent = Intent(Intent.ACTION_VIEW)
        val uri = FileProvider.getUriForFile(activity,  "${activity.packageName}.provider", file)

        var mime = "*/*"

        val mimeTypeMap = MimeTypeMap.getSingleton()

        if (mimeTypeMap.hasExtension(
                        MimeTypeMap.getFileExtensionFromUrl(uri.toString()))) {
            mime = mimeTypeMap.getMimeTypeFromExtension(
                    MimeTypeMap.getFileExtensionFromUrl(uri.toString())) ?: "*/*"
        }
        intent.flags = FLAG_GRANT_READ_URI_PERMISSION

        intent.setDataAndType(uri, mime)
        activity.startActivity(intent)

    }
}