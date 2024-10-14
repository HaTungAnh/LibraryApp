package com.example.libraryapp.addbooks.presentation

import android.graphics.Bitmap
import androidx.camera.view.LifecycleCameraController
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CameraViewModel @Inject constructor(): ViewModel() {

    private val _photos = MutableStateFlow<List<Bitmap>>(emptyList())
    val photos = _photos.asStateFlow()

    fun onTakePhoto(photo: Bitmap) {
        _photos.value += photo
    }

}