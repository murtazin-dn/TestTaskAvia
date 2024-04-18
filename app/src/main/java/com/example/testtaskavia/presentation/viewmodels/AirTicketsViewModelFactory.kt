package com.example.testtaskavia.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.domain.usecase.GetOffersUseCase
import javax.inject.Inject

class AirTicketsViewModelFactory @Inject constructor(
    private val getOffersUseCase: GetOffersUseCase
) : ViewModelProvider.Factory  {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return AirTicketsViewModel(
            getOffersUseCase
        ) as T
    }
}