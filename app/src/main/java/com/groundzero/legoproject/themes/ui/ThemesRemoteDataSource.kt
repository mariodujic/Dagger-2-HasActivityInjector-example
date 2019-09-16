package com.groundzero.legoproject.themes.ui

import com.groundzero.legoproject.api.BaseDataSource
import com.groundzero.legoproject.api.LegoApi
import javax.inject.Inject

class ThemesRemoteDataSource @Inject constructor(private val api: LegoApi): BaseDataSource() {

    suspend fun fetchThemes() =
        getResult{api.getThemes(1, 1000, "-id")}
}