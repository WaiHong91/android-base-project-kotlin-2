package com.wenyang.androidbaseprojectmodule.utility.helper

import android.net.Uri
import com.wenyang.androidbaseprojectmodule.utility.extension.toFile
import dagger.Reusable
import java.io.ByteArrayInputStream
import java.io.File
import java.io.FileOutputStream
import java.nio.charset.Charset
import javax.crypto.Cipher
import javax.crypto.SecretKeyFactory
import javax.crypto.spec.PBEKeySpec
import javax.inject.Inject

/**
 * Created by wenyang on 12/3/18.
 */

@Reusable
class DecryptionHelper @Inject constructor() {

    fun decryptIntoByte(fileUri: Uri, password: String): ByteArray? {

        val decryptionKeyFile = fileUri.toFile()

        val encryptedBytes = decryptionKeyFile.readBytes()

        val cipher = Cipher.getInstance("AES/CBC/PKCS7Padding", "BC")

        val salt = ByteArray(8)

        System.arraycopy(encryptedBytes, 8, salt, 0, 8)

        val fact = SecretKeyFactory.getInstance("PBEWITHMD5AND256BITAES-CBC-OPENSSL", "BC")

        cipher.init(Cipher.DECRYPT_MODE, fact.generateSecret(PBEKeySpec(password.toCharArray(), salt, 100)))

        return try {
            cipher.doFinal(encryptedBytes, 16, encryptedBytes.size - 16)
        } catch (ex: Exception) {
            null
        }
    }

    fun decryptIntoByteArrayInputStream(fileUri: Uri, password: String): ByteArrayInputStream {

        val bytes = decryptIntoByte(fileUri, password)

        return ByteArrayInputStream(bytes)
    }

    fun decryptIntoFile(fileUri: Uri, password: String): File {

        val filename = fileUri.lastPathSegment

        val tempFileName = "temp_$filename"

        var filePath = fileUri.path?.substringBeforeLast("/") ?: ""
        filePath = "$filePath/$tempFileName"

        val tempFile = File(filePath)

        if (tempFile.exists()) {
            tempFile.delete()
        }

        tempFile.createNewFile()

        val decryptedBytes = decryptIntoByte(fileUri, password)

        val fileOutputStream = FileOutputStream(tempFile)

        fileOutputStream.write(decryptedBytes)

        fileOutputStream.close()

        return tempFile
    }

    fun decryptIntoString(fileUri: Uri, password: String): String? {

        val bytes = decryptIntoByte(fileUri, password)

        return bytes?.toString(Charset.forName("UTF-8"))
    }
}