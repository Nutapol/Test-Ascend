package com.example.test_ascend.Activity.main.di

import com.example.test_ascend.Activity.main.navigator.Navigator
import com.example.test_ascend.Activity.main.service.OkHttpBuilder
import com.example.test_ascend.Activity.main.service.RetrofitBuilder
import com.example.test_ascend.Activity.main.service.TokenExpireInterceptor
import org.koin.dsl.module

class AppModule {

    val module = module {
        single { Navigator() }

        single { RetrofitBuilder(okHttpClient = get()) }
        factory { TokenExpireInterceptor() }
        factory { OkHttpBuilder(interceptor = get()).build() }

    }
}