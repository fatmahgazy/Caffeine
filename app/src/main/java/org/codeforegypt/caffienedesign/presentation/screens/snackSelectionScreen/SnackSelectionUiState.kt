package org.codeforegypt.caffienedesign.presentation.screens.snackSelectionScreen

import org.codeforegypt.caffienedesign.domian.Snack

data class SnackSelectionUiState(
    val snacks: List<Snack> = emptyList()
)