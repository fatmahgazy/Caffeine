package org.codeforegypt.caffienedesign.di

import org.codeforegypt.caffienedesign.presentation.screens.snackSelectionScreen.SnackSelectionViewModel
import org.codeforegypt.caffienedesign.presentation.screens.enjoyScreen.EnjoyScreenViewModel
import org.codeforegypt.caffienedesign.presentation.screens.morningScreen.MorningCoffeeViewModel
import org.codeforegypt.caffienedesign.presentation.screens.orderSizeDetailsScreen.OrderDetailsViewModel
import org.codeforegypt.caffienedesign.presentation.screens.orderReadyScreen.OrderViewModel
import org.codeforegypt.caffienedesign.presentation.screens.processingScreen.ProcessingViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    viewModel { MorningCoffeeViewModel() }
    viewModel { params -> OrderDetailsViewModel(savedStateHandle = params.get()) }
    viewModel { params -> ProcessingViewModel(savedStateHandle = params.get()) }
    viewModel { params -> OrderViewModel(savedStateHandle = params.get()) }
    viewModel { SnackSelectionViewModel() }
    viewModel { params -> EnjoyScreenViewModel(savedStateHandle = params.get()) }

}