package com.wenyang.androidbaseprojectmodule.utility.helper

import android.app.Activity
import android.content.Context
import androidx.appcompat.app.AlertDialog
import android.view.LayoutInflater
import com.wenyang.androidbaseprojectmodule.R
import com.wenyang.androidbaseprojectmodule.utility.extension.logcat
import kotlinx.android.synthetic.main.dialog_edit_text.view.*

/**
 * Created by wenyang on 8/12/17.
 */

interface DialogHandlerCallback {
    fun onPositiveButtonClick()
    fun onNegativeButtonClick()
}

interface EditTextDialogHandlerCallback {
    fun onPositiveButtonClick(text: String)
    fun onNegativeButtonClick()
}

abstract class BaseDialogHandler constructor(val context: Context) {

    var inflater: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    fun launchWithSingleButton(titleResId: Int,
                               message: String,
                               callback: DialogHandlerCallback) {
        val title = context.getString(titleResId)
        val positiveButtonText = context.getString(R.string.action_ok)

        launch(title = title,
                message = message,
                positiveButtonText = positiveButtonText,
                callback = callback)
    }

    fun launchWithSingleButton(titleResId: Int,
                               messageResId: Int,
                               callback: DialogHandlerCallback) {
        val title = context.getString(titleResId)
        val message = context.getString(messageResId)
        val positiveButtonText = context.getString(R.string.action_ok)

        launch(title = title,
                message = message,
                positiveButtonText = positiveButtonText,
                callback = callback)
    }

    fun launchWithDoubleButton(titleResId: Int,
                               messageResId: Int,
                               callback: DialogHandlerCallback) {

        val title = context.getString(titleResId)
        val message = context.getString(messageResId)
        val positiveButtonText = context.getString(R.string.action_ok)
        val negativeButtonText = context.getString(R.string.action_cancel)

        launch(title = title,
                message = message,
                positiveButtonText = positiveButtonText,
                negativeButtonText = negativeButtonText,
                callback = callback)
    }

    fun launchWithDoubleButton(titleResId: Int,
                               message: String,
                               callback: DialogHandlerCallback) {

        val title = context.getString(titleResId)
        val positiveButtonText = context.getString(R.string.action_ok)
        val negativeButtonText = context.getString(R.string.action_cancel)

        launch(title = title,
                message = message,
                positiveButtonText = positiveButtonText,
                negativeButtonText = negativeButtonText,
                callback = callback)
    }

    fun launch(title: String,
               message: String,
               positiveButtonText: String,
               negativeButtonText: String? = null,
               callback: DialogHandlerCallback) {

        val dialogBuilder = AlertDialog.Builder(context)

        dialogBuilder.setTitle(title)
        dialogBuilder.setMessage(message)
        dialogBuilder.setPositiveButton(positiveButtonText) { dialog, which ->

            dialog.dismiss()

            callback.onPositiveButtonClick()
        }

        if (negativeButtonText != null) {
            dialogBuilder.setNegativeButton(negativeButtonText) { dialog, which ->

                dialog.dismiss()

                callback.onNegativeButtonClick()
            }
        }

        dialogBuilder.setIcon(android.R.drawable.ic_dialog_info)
        dialogBuilder.setCancelable(false)

        val dialog = dialogBuilder.create()

        show(dialog)
    }

    fun launchWithEditText(titleResId: Int,
                           hintResId: Int,
                           callback: EditTextDialogHandlerCallback) {

        val title = context.getString(titleResId)
        val hint = context.getString(hintResId)
        val negativeButtonText = context.getString(R.string.action_cancel)
        val positiveButtonText = context.getString(R.string.action_ok)

        launchWithEditText(title, hint, positiveButtonText, negativeButtonText, callback)
    }

    fun launchWithEditText(title: String,
                           hint: String,
                           positiveButtonText: String,
                           negativeButtonText: String? = null,
                           callback: EditTextDialogHandlerCallback) {

        val view = inflater.inflate(R.layout.dialog_edit_text, null)


        view.textinputlayout_eddittextdialog.hint = hint

        val dialogBuilder = AlertDialog.Builder(context)

        dialogBuilder.setTitle(title)
        dialogBuilder.setView(view)
        dialogBuilder.setPositiveButton(positiveButtonText) { dialog, which ->

            dialog.dismiss()

            val text = view.edittext_edittextdialog.text.toString()

            callback.onPositiveButtonClick(text)
        }

        if (negativeButtonText != null) {
            dialogBuilder.setNegativeButton(negativeButtonText) { dialog, which ->

                dialog.dismiss()

                callback.onNegativeButtonClick()
            }
        }

        dialogBuilder.setIcon(android.R.drawable.ic_dialog_info)
        dialogBuilder.setCancelable(false)

        val dialog = dialogBuilder.create()

        show(dialog)
    }

    fun show(alertDialog: AlertDialog) {

        if ((context as? Activity)?.isFinishing == true) return

        alertDialog.show()
    }

}