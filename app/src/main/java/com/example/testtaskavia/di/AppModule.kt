package com.example.testtaskavia.di

import com.example.domain.usecase.GetOffersUseCase
import com.example.testtaskavia.presentation.viewmodels.AirTicketsViewModelFactory
import dagger.Module

@Module
class AppModule {
    fun provideAirTicketsViewModelFactory(
        getOffersUseCase: GetOffersUseCase
    ): AirTicketsViewModelFactory{
        return AirTicketsViewModelFactory(
            getOffersUseCase = getOffersUseCase
        )
    }
}