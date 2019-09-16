package com.groundzero.legoproject.themes.data

import com.groundzero.legoproject.data.resultLiveData
import com.groundzero.legoproject.themes.ui.ThemesRemoteDataSource
import javax.inject.Inject


class ThemesRepository @Inject constructor(private val dataSource: ThemesRemoteDataSource) {

    val themes = resultLiveData(networkCall = {dataSource.fetchThemes()})
}