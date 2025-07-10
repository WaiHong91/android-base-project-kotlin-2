package com.wenyang.androidbaseprojectmodule.utility.helper

import android.app.Activity
import android.content.Context
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.RelativeLayout
import com.wenyang.androidbaseprojectmodule.R
import com.wenyang.androidbaseprojectmodule.dagger.scope.PerActivity
import com.wenyang.androidbaseprojectmodule.utility.extension.color
import javax.inject.Inject

/**
 * Created by wenyang on 13/11/17.
 */

@PerActivity
class ProgressBarHandler @Inject constructor(val context: Context) {

    var progressBar: ProgressBar

    init {

        val layout = (context as Activity).findViewById<ViewGroup>(android.R.id.content).rootView as ViewGroup

        progressBar = ProgressBar(context, null)
        progressBar.isIndeterminate = true

        progressBar.indeterminateDrawable
                .setColorFilter(context.color(R.color.colorAccent),
                        android.graphics.PorterDuff.Mode.MULTIPLY)

        val params = RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.MATCH_PARENT)

        val relativeLayout = RelativeLayout(context)

        relativeLayout.gravity = Gravity.CENTER
        relativeLayout.addView(progressBar)

        layout.addView(relativeLayout, params)

        hide()

    }

    fun show() {
        progressBar.visibility = View.VISIBLE
    }

    fun hide() {
        progressBar.visibility = View.INVISIBLE
    }

}