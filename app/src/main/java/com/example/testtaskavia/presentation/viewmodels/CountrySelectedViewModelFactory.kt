package com.example.testtaskavia.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.domain.usecase.GetOffersUseCase
import com.example.domain.usecase.GetTicketsOfferUseCase
import javax.inject.Inject

class CountrySelectedViewModelFactory @Inject constructor(
    private val getTicketsOfferUseCase: GetTicketsOfferUseCase
) : ViewModelProvider.Factory  {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return CountrySelectedViewModel(
            getTicketsOfferUseCase
        ) as T
    }
}