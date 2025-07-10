package com.wenyang.androidbaseprojectmodule.utility.extension

import android.net.Uri
import java.io.File

/**
 * Created by wenyang on 14/2/18.
 */

fun File.toUri(): Uri {


    return Uri.fromFile(this)
}

fun Uri.toFile(): File {

    return File(this.path)
}

fun File.getInfoAsJson(): String {

    if (this.isDirectory) {

        val filesArray = this.listFiles()

        if (filesArray.isEmpty()) {
            return this.getSingleFileInfo()
        }

        val childrenFilesJson = StringBuilder(",\"children\":[")

        filesArray.forEachIndexed { index, file ->

            childrenFilesJson.append(file.getInfoAsJson())

            if (index != filesArray.size - 1) {
                childrenFilesJson.append(",")
            }
        }

        childrenFilesJson.append("]")

        return "{" +
                "\"name\" : " + "\"" + this.name + "\"" +
                ",\"datetime\" : " + this.lastModified() +
                ",\"type\" : \"folder\"" +
                childrenFilesJson.toString() +
                "}"
    }

    return this.getSingleFileInfo()
}

fun File.getSingleFileInfo(): String {

    var type = "file"

    if (this.isDirectory) {

        type = "folder"
    }

    return "{" +
            "\"name\" : " + "\"" + this.getName() + "\"" +
            ",\"datetime\" : " + this.lastModified() +
            ",\"type\" : " + "\"" + type + "\"" +
            ",\"size\" : " + this.length() +
            "}"
}

fun File.getInfoAsJsonWithoutFirstLevel(): String {

    val stringBuilder = StringBuilder("[")

    if (this.isDirectory) {

        val fileArray = this.listFiles()

        fileArray.forEachIndexed { index, file ->

            stringBuilder.append(file.getInfoAsJson())

            if (index != fileArray.size - 1) {
                stringBuilder.append(",")
            }

        }
    } else {
        stringBuilder.append(this.getSingleFileInfo())
    }

    stringBuilder.append("]")

    return stringBuilder.toString()
//            File[] files = file.listFiles();
//
//            for (int i = 0; i < files.length; i++) {
//
//                File childFile = files[i];
//
//                stringBuilder.append(grabInfoAsJson(childFile));
//
//                if (i != files.length - 1) {
//
//                    stringBuilder.append(",");
//
//                }
//            }
//
//        }else{
//
//            stringBuilder.append(grabSingleFileInfo(file));
//        }
//
//        stringBuilder.append("]");
//
//        return stringBuilder.toString();
//
//
////        return grabSingleFileInfo(file);
//
//    }
}
//String grabSingleFileInfo(File file) {
//
//    String type = "file";
//
//    if (file.isDirectory()) {
//
//        type = "folder";
//    }
//
//    return "{" +
//            "\"name\" : " + "\"" + file.getName() + "\"" +
//            ",\"datetime\" : " + file.lastModified() +
//            ",\"type\" : " + "\"" + type + "\"" +
//            ",\"size\" : " + file.length() +
//            "}";
//}

//String grabInfoAsJson(File file) {
//
//
//    if (file.isDirectory()) {
//
//        File[] files = file.listFiles();
//
//        if (files.length == 0) {
//
//            return grabSingleFileInfo(file);
//        }
//
//        StringBuilder childrenFilesJson = new StringBuilder(",\"children\":[");
//
//        for (int i = 0; i < files.length; i++) {
//
//            File childFile = files[i];
//
//            childrenFilesJson.append(grabInfoAsJson(childFile));
//
//            if (i != files.length - 1) {
//
//                childrenFilesJson.append(",");
//
//            }
//        }
//
//        childrenFilesJson.append("]");
//
//        return "{" +
//                "\"name\" : " + "\"" + file.getName() + "\"" +
//                ",\"datetime\" : " + file.lastModified() +
//                ",\"type\" : \"folder\"" +
//                childrenFilesJson.toString() +
//                "}";
//    }
//
//    return grabSingleFileInfo(file);
//
//}
//
//String grabSingleFileInfo(File file) {
//
//    String type = "file";
//
//    if (file.isDirectory()) {
//
//        type = "folder";
//    }
//
//    return "{" +
//            "\"name\" : " + "\"" + file.getName() + "\"" +
//            ",\"datetime\" : " + file.lastModified() +
//            ",\"type\" : " + "\"" + type + "\"" +
//            ",\"size\" : " + file.length() +
//            "}";
//}