package com.groundzero.legoproject.di.components

import android.app.Application
import com.groundzero.legoproject.base.App
import com.groundzero.legoproject.di.coremodules.ActivityModule
import com.groundzero.legoproject.di.coremodules.AppModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        AppModule::class,
        ActivityModule::class
    ]
)
interface AppComponent {
    fun inject(application: App)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }
}