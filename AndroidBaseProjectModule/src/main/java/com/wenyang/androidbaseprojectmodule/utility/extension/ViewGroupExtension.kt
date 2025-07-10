package com.wenyang.androidbaseprojectmodule.utility.extension

import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

/**
 * Created by wenyang on 15/11/17.
 */


fun TextInputEditText.showErrorInLayout(stringResId: Int?){

    val textInputLayout = this.parent.parent as? TextInputLayout
            ?: return

    if(stringResId == null) {
        textInputLayout.isErrorEnabled = false
        return
    }

    textInputLayout.isErrorEnabled = true
    textInputLayout.error = context.getString(stringResId)

}