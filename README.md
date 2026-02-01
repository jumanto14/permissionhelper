# PermissionHelper

[![](https://jitpack.io/v/jumanto14/loghelper.svg)](https://jitpack.io/#jumanto14/loghelper)

A clean, lightweight, and professional Android runtime permission helper written in Kotlin.  
Built for modern Android development using Activity Result API.

---

## ✨ Features

- Single & multiple permission request
- Modern Activity Result API (no deprecated callbacks)
- Handle permission states:
  - Granted
  - Denied
  - Permanently denied (Don't ask again)
- Clean callback-based API
- Minimal dependencies
- Beginner friendly, production ready
- Android 6.0+ (API 21+)

---

## 📦 Installation

### Step 1. Add JitPack repository

```gradle
repositories {
    maven { url "https://jitpack.io" }
}
```

### Step 2. Add dependency

```gradle
dependencies {
    implementation("com.github.jumanto14:permissionhelper:v1.0.0")
}
```

---

## 🚀 Usage

### Request Single Permission

```kotlin
PermissionHelper(
    this,
    arrayOf(android.Manifest.permission.CAMERA)
).request(object : PermissionCallback {

    override fun onGranted() {
        // Permission granted
    }

    override fun onDenied(deniedPermissions: List<String>) {
        // Permission denied
    }

    override fun onPermanentlyDenied(permanentlyDeniedPermissions: List<String>) {
        PermissionSettings.openAppSettings(this@MainActivity)
    }
})
```

---

### Request Multiple Permissions

```kotlin
PermissionHelper(
    this,
    arrayOf(
        android.Manifest.permission.CAMERA,
        android.Manifest.permission.READ_EXTERNAL_STORAGE
    )
).request(object : PermissionCallback {

    override fun onGranted() {}

    override fun onDenied(deniedPermissions: List<String>) {}

    override fun onPermanentlyDenied(permanentlyDeniedPermissions: List<String>) {
        PermissionSettings.openAppSettings(this@MainActivity)
    }
})
```

---

## ⚙️ Open App Settings

```kotlin
PermissionSettings.openAppSettings(context)
```

---

## 🧠 Best Practice

- Do not request permissions at app launch
- Explain why the permission is needed before requesting
- Request permission only when the feature is about to be used
- Open settings only if permission is permanently denied

---

## 📄 Requirements

- Android API 21+
- Kotlin
- AndroidX

---

## 📄 License

MIT License — free to use in personal and commercial projects.

---

## 👨‍💻 Author

**Jumanto**  
Android Developer — Indonesia 🇮🇩  
GitHub: https://github.com/jumanto14
