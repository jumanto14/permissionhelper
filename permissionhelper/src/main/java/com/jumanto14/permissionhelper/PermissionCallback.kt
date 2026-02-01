package com.jumanto14.permissionhelper

interface PermissionCallback {

    /** Semua permission diberikan */
    fun onGranted()

    /** Permission ditolak (tapi belum permanent) */
    fun onDenied(deniedPermissions: List<String>)

    /** Permission ditolak permanen (Don't ask again) */
    fun onPermanentlyDenied(permanentlyDeniedPermissions: List<String>)
}
