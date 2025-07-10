package com.wenyang.androidbaseprojectmodule.utility.extension

import android.content.Context
import android.text.Html
import android.webkit.MimeTypeMap
import com.wenyang.androidbaseprojectmodule.R
import java.util.regex.Pattern

fun String.getMimeType() : String?{

    val extension = MimeTypeMap.getFileExtensionFromUrl(this) ?: return null

    return when (extension) {
        "json" -> {
            "text/json"
        }

        "js" -> {
            "text/javascript"
        }

        "xhtml" -> {
            "text/html"
        }

        else -> {

            MimeTypeMap.getSingleton().getMimeTypeFromExtension(extension)
        }
    }
}

//EMAIL
const val EMAIL_PATTERN = "^[a-zA-Z0-9#_~!$&'()*+,;=:.\"(),:;<>@\\[\\]\\\\]+@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*$"

//Password
const val PASSWORD_MIN_LENGTH = 8

fun String.isValidEmail(): Boolean {
    val pattern = Pattern.compile(EMAIL_PATTERN)
    return pattern.matcher(this).matches()
}

fun String.checkLoginCredentialBlank() : Int?{

    if (this.isBlank()) return R.string.error_loginid_empty_field

    return null
}

fun String.checkBlank() : Int?{

    if (this.isBlank()) return R.string.error_empty_field

    return null
}

fun String.isValidPassword(): Int?{

    if (this.isBlank()) return R.string.error_password_empty_field

    if (this.length < 8 ) return R.string.error_password_invalid

    return null
}

fun String.removeHtmlTag() : String?{

    if(this.isBlank()){
        return this
    }

    val string = this.replace("<img.+?>","")

//    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
//        return Html.fromHtml(html, Html.FROM_HTML_MODE_LEGACY);
//    } else {
//        return Html.fromHtml(html);
//    }

    return Html.fromHtml(this).toString()
            .replace(   '\n',  32.toChar())
            .replace(160.toChar(),32.toChar())
            .replace(65532.toChar(), 32.toChar())
            .trim()


}

fun String.toFilename() : String? {
    return this.substringAfterLast("/")
}