package com.example.testtaskavia.app

import android.app.Application
import com.example.testtaskavia.di.AppComponent
import com.example.testtaskavia.di.DaggerAppComponent

class App : Application() {

    lateinit var appComponent: AppComponent
    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.create()
    }
}