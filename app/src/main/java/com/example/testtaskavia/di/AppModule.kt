package com.example.testtaskavia.di

import android.app.Application
import android.content.Context
import com.example.domain.usecase.GetFromTextUseCase
import com.example.domain.usecase.GetOffersUseCase
import com.example.domain.usecase.GetTicketsOfferUseCase
import com.example.domain.usecase.GetTicketsUseCase
import com.example.domain.usecase.SaveFromTextUseCase
import com.example.testtaskavia.presentation.viewmodels.AirTicketsViewModelFactory
import com.example.testtaskavia.presentation.viewmodels.CountrySelectedViewModelFactory
import com.example.testtaskavia.presentation.viewmodels.TicketsViewModelFactory
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(val context: Context) {

    @Provides
    fun provideContext(): Context {
        return context
    }
    fun provideAirTicketsViewModelFactory(
        getOffersUseCase: GetOffersUseCase,
        getFromTextUseCase: GetFromTextUseCase,
        saveFromTextUseCase: SaveFromTextUseCase
    ): AirTicketsViewModelFactory{
        return AirTicketsViewModelFactory(
            getOffersUseCase = getOffersUseCase,
            getFromTextUseCase = getFromTextUseCase,
            saveFromTextUseCase = saveFromTextUseCase
        )
    }
    fun provideCountrySelectedViewModelFactory(
        getTicketsOfferUseCase: GetTicketsOfferUseCase
    ): CountrySelectedViewModelFactory {
        return CountrySelectedViewModelFactory(
            getTicketsOfferUseCase = getTicketsOfferUseCase
        )
    }
    fun provideTicketsViewModelFactory(
        getTicketsUseCase: GetTicketsUseCase
    ): TicketsViewModelFactory {
        return TicketsViewModelFactory(
            getTicketsUseCase = getTicketsUseCase
        )
    }
}