package org.codeforegypt.caffienedesign

import android.app.Application
import org.codeforegypt.caffienedesign.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class CaffeineApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@CaffeineApplication)
            modules(appModule)
        }
    }
}