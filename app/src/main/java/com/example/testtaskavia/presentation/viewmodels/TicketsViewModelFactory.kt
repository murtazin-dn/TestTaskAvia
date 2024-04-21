package com.example.testtaskavia.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.domain.usecase.GetTicketsOfferUseCase
import com.example.domain.usecase.GetTicketsUseCase
import javax.inject.Inject

class TicketsViewModelFactory @Inject constructor(
    private val getTicketsUseCase: GetTicketsUseCase
) : ViewModelProvider.Factory  {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return TicketsViewModel(
            getTicketsUseCase
        ) as T
    }
}