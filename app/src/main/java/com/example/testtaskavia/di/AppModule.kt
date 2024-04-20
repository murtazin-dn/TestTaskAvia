package com.example.testtaskavia.di

import com.example.domain.usecase.GetOffersUseCase
import com.example.domain.usecase.GetTicketsOfferUseCase
import com.example.testtaskavia.presentation.viewmodels.AirTicketsViewModelFactory
import com.example.testtaskavia.presentation.viewmodels.CountrySelectedViewModelFactory
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
    fun provideCountrySelectedViewModelFactory(
        getTicketsOfferUseCase: GetTicketsOfferUseCase
    ): CountrySelectedViewModelFactory {
        return CountrySelectedViewModelFactory(
            getTicketsOfferUseCase = getTicketsOfferUseCase
        )
    }
}