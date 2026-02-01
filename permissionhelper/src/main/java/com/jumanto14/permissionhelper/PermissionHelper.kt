package com.jumanto14.permissionhelper

import androidx.activity.ComponentActivity
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts

class PermissionHelper(
    private val activity: ComponentActivity,
    private val permissions: Array<String>
) {

    private var callback: PermissionCallback? = null

    private val launcher: ActivityResultLauncher<Array<String>> =
        activity.registerForActivityResult(
            ActivityResultContracts.RequestMultiplePermissions()
        ) { result ->

            val denied = mutableListOf<String>()
            val permanentlyDenied = mutableListOf<String>()

            result.forEach { (permission, granted) ->
                if (!granted) {
                    if (PermissionUtils.isPermanentlyDenied(activity, permission)) {
                        permanentlyDenied.add(permission)
                    } else {
                        denied.add(permission)
                    }
                }
            }

            when {
                denied.isEmpty() && permanentlyDenied.isEmpty() ->
                    callback?.onGranted()

                permanentlyDenied.isNotEmpty() ->
                    callback?.onPermanentlyDenied(permanentlyDenied)

                else ->
                    callback?.onDenied(denied)
            }
        }

    fun request(callback: PermissionCallback) {
        this.callback = callback

        if (PermissionUtils.hasPermissions(activity, permissions)) {
            callback.onGranted()
        } else {
            launcher.launch(permissions)
        }
    }
}
