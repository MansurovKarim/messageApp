package com.example.messageapp

import android.app.Application
import com.example.messageapp.di.appModules
import com.example.messageapp.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class ChatApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@ChatApplication)
            modules(appModules, viewModelModule)
        }
    }
}