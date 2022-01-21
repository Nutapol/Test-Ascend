package com.example.test_ascend.Activity.main

import android.app.Application
import androidx.lifecycle.ViewModel
import com.example.test_ascend.Activity.main.di.AppModule
import com.example.test_ascend.Activity.main.di.fetures.ProductModule
import com.example.test_ascend.Activity.main.di.viewmodel.ViewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.logger.AndroidLogger
import org.koin.core.context.startKoin

class MyApplication: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MyApplication)

            modules(
                ProductModule().module,
                AppModule().module,
                ViewModelModule().module
            )
            logger(
                AndroidLogger()
            )
        }
    }
}