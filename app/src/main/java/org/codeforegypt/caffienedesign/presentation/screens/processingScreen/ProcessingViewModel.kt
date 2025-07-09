package org.codeforegypt.caffienedesign.presentation.screens.processingScreen

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

class ProcessingViewModel(savedStateHandle: SavedStateHandle) : ViewModel() {


    val coffeeId: Int = checkNotNull(savedStateHandle["coffeeId"])
    val size: String = checkNotNull(savedStateHandle["size"])
    val volume: String = checkNotNull(savedStateHandle["volume"])
}