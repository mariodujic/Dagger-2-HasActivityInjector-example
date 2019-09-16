package com.groundzero.legoproject.di.coremodules

import com.groundzero.legoproject.di.modules.RemoteModule
import com.groundzero.legoproject.di.modules.ViewModelModule
import dagger.Module

@Module(includes = [RemoteModule::class, ViewModelModule::class])
interface AppModule