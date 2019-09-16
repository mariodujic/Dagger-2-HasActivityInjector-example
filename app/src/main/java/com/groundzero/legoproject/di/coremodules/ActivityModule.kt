package com.groundzero.legoproject.di.coremodules

import com.groundzero.legoproject.base.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {
    @ContributesAndroidInjector(modules = [FragmentsModule::class])
    abstract fun contributeActivity(): MainActivity
}