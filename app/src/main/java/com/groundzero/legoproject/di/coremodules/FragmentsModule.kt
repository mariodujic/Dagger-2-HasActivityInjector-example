package com.groundzero.legoproject.di.coremodules

import com.groundzero.legoproject.singletheme.ui.SingleThemeFragment
import com.groundzero.legoproject.themes.ui.ThemesFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentsModule {
    @ContributesAndroidInjector
    abstract fun contributeThemeFragment(): ThemesFragment
    @ContributesAndroidInjector
    abstract fun contributeSingleThemeFragment(): SingleThemeFragment
}