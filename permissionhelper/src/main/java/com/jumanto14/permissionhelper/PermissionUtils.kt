package com.jumanto14.permissionhelper

import android.app.Activity
import android.content.pm.PackageManager
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

internal object PermissionUtils {

    fun hasPermission(activity: Activity, permission: String): Boolean {
        return ContextCompat.checkSelfPermission(
            activity,
            permission
        ) == PackageManager.PERMISSION_GRANTED
    }

    fun hasPermissions(activity: Activity, permissions: Array<String>): Boolean {
        return permissions.all { hasPermission(activity, it) }
    }

    fun isPermanentlyDenied(
        activity: Activity,
        permission: String
    ): Boolean {
        return !ActivityCompat.shouldShowRequestPermissionRationale(
            activity,
            permission
        )
    }
}
