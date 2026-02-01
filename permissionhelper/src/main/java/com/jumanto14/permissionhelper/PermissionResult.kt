package com.jumanto14.permissionhelper

sealed class PermissionResult {
    object Granted : PermissionResult()
    data class Denied(val permissions: List<String>) : PermissionResult()
    data class PermanentlyDenied(val permissions: List<String>) : PermissionResult()
}
