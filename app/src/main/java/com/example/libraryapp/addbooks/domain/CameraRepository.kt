package com.example.libraryapp.addbooks.domain

import androidx.camera.view.LifecycleCameraController

interface CameraRepository {

    suspend fun takePhoto(controller: LifecycleCameraController)
}