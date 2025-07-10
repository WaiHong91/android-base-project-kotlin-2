package com.wenyang.androidbaseprojectmodule.dagger.utility

import android.content.ActivityNotFoundException
import android.os.Handler
import androidx.annotation.IdRes
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import android.view.WindowManager
import android.widget.Toast
import com.karumi.dexter.Dexter
import com.karumi.dexter.MultiplePermissionsReport
import com.karumi.dexter.PermissionToken
import com.karumi.dexter.listener.PermissionRequest
import com.karumi.dexter.listener.multi.MultiplePermissionsListener
import com.wenyang.androidbaseprojectmodule.R
import com.wenyang.androidbaseprojectmodule.router.BaseRouter
import com.wenyang.androidbaseprojectmodule.utility.helper.BaseDialogHandler
import com.wenyang.androidbaseprojectmodule.utility.helper.ProgressBarHandler


abstract class BaseActivityUtility constructor(private val activity: AppCompatActivity,
                                               val progressBarHandler: ProgressBarHandler,
                                               val baseDialogHandler: BaseDialogHandler,
                                               val baseRouter: BaseRouter) {

    fun toastMessage(string: String) {

        if (activity.isFinishing) {
            return
        }

        Toast.makeText(activity, string, Toast.LENGTH_LONG).show()
    }

    fun toastMessage(stringResId: Int) {

        val string = getStringResource(stringResId)

        toastMessage(string)
    }

    fun getStringResource(stringResId: Int): String =
            activity.getString(stringResId)

    fun finishActivity() {

        activity.finish()
    }

    fun showProgressBar() {

        progressBarHandler.show()


        activity.window.setFlags(
                WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE)
    }

    fun hideProgressBar() {
        progressBarHandler.hide()

        activity.window.clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE)

    }

    fun examineError(errorStringResId: Int?, errorMessageFromServer: String?): Boolean {

        if (errorStringResId != null) {

            toastMessage(errorStringResId)
            return true
        }

        if (errorMessageFromServer != null) {

            toastMessage(errorMessageFromServer)
            return true
        }

        return false
    }

    fun getStringResourceArrayList(arrayResId: Int) = activity.resources.getStringArray(arrayResId).toList()

    fun showDialogFragment(dialogFragment: DialogFragment) {

        if(activity.isFinishing){
            return
        }

        val fragmentTransaction = activity.supportFragmentManager.beginTransaction()

        dialogFragment.show(fragmentTransaction, dialogFragment.toString())

    }

    fun runInMainThread(completionHandler: () -> Unit) {

        val handler = Handler(activity.mainLooper)

        handler.post {
            completionHandler()
        }
    }

    fun launchExternalFileViewer(fileUrl: String) {

        try {
            baseRouter.navigateToExternalFileViewer(fileUrl)
        } catch (ex: ActivityNotFoundException) {
            toastMessage("not supported")
        }
    }

    fun seekForPermissions(permissions: Collection<String>, permissionCallback: PermissionCallback) {

        Dexter.withActivity(activity)
                .withPermissions(permissions)
                .withListener(object : MultiplePermissionsListener {
                    override fun onPermissionsChecked(report: MultiplePermissionsReport?) {

                        val isAllAccepted = report?.areAllPermissionsGranted() ?: false

                        if (isAllAccepted) {

                            permissionCallback.onAccepted()
                            permissionCallback.onDismissed()
                            return
                        }

                        toastMessage(R.string.error_permission_not_granted)
                        permissionCallback.onRejected()
                        permissionCallback.onDismissed()
                    }

                    override fun onPermissionRationaleShouldBeShown(permissions: MutableList<PermissionRequest>?, token: PermissionToken?) {

                        token?.continuePermissionRequest()
                    }

                }).check()
    }


    fun showFragment(@IdRes containerViewId: Int, fragment: Fragment) {

        if(activity.isFinishing){
            return
        }

        activity.supportFragmentManager
                .beginTransaction()
                .replace(containerViewId, fragment)
                .disallowAddToBackStack()
                .commitAllowingStateLoss()
    }

    interface PermissionCallback {
        fun onAccepted()
        fun onRejected()
        fun onDismissed()
    }
}