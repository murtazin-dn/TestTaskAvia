package com.example.testtaskavia.di

import com.example.domain.repository.OffersRepository
import com.example.domain.usecase.GetOffersUseCase
import dagger.Module
import dagger.Provides

@Module
class DomainModule {

    @Provides
    fun providesGetOffersUseCase(offersRepository: OffersRepository): GetOffersUseCase =
        GetOffersUseCase(offersRepository)
}