package com.example.messageapp.di

import com.shabelnikd.danielapichat.model.core.RetrofitClient
import com.example.messageapp.data.service.ChatApiServiceImpl
import com.example.messageapp.ui.fragments.chat.ChatViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val appModules = module {
    single { RetrofitClient(androidContext()) }
    single { get<RetrofitClient>().retrofitService }
    single { ChatApiServiceImpl(get()) }
}

val viewModelModule = module() {
    viewModel { ChatViewModel() }
}