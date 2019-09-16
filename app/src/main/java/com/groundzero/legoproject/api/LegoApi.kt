package com.groundzero.legoproject.api

import com.groundzero.legoproject.BuildConfig
import com.groundzero.legoproject.themes.data.LegoTheme
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface LegoApi {

    @GET("lego/themes/")
    suspend fun getThemes(@Query("page") page: Int? = null,
                          @Query("page_size") pageSize: Int? = null,
                          @Query("ordering") order: String? = null): Response<ResultsResponse<LegoTheme>>

    companion object{
        const val BASE_URL = "https://rebrickable.com/api/v3/"
        const val API_KEY = BuildConfig.LEGO_API_KEY
    }
}