package com.ficha.dd

import android.app.Application
import com.ficha.dd.di.dndAppModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class DndApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        // start Koin!
        startKoin {
            // declare used Android context
            androidContext(applicationContext)
            // declare modules
            modules(dndAppModule)
        }
    }
}