package com.groundzero.legoproject.di.modules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.groundzero.legoproject.di.helper.ViewModelFactory
import com.groundzero.legoproject.di.scopes.ViewModelKey
import com.groundzero.legoproject.themes.ui.ThemesViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(ThemesViewModel::class)
    abstract fun bindThemeViewModel(viewModel: ThemesViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}