package com.jumanto14.permissionhelper

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.provider.Settings

object PermissionSettings {

    fun openAppSettings(context: Context) {
        val intent = Intent(
            Settings.ACTION_APPLICATION_DETAILS_SETTINGS,
            Uri.fromParts("package", context.packageName, null)
        )
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        context.startActivity(intent)
    }
}
