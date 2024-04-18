package com.example.testtaskavia.di

import com.example.testtaskavia.presentation.ui.AirTicketsFragment
import dagger.Component

@Component(modules = [AppModule::class, DomainModule::class, DataModule::class])
interface AppComponent {
    fun inject(airTicketsFragment: AirTicketsFragment)
}