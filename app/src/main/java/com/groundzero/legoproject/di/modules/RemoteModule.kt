package com.groundzero.legoproject.di.modules

import com.google.gson.Gson
import com.groundzero.legoproject.api.AuthInterceptor
import com.groundzero.legoproject.api.LegoApi
import com.groundzero.legoproject.di.scopes.LegoAPI
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class RemoteModule {

    @Provides
    @Singleton
    fun provideLegoApi(
        @LegoAPI client: OkHttpClient,
        converterFactory: GsonConverterFactory
    ) = createApi(client, converterFactory, LegoApi::class.java)

    private fun <T> createApi(
        client: OkHttpClient,
        converterFactory: GsonConverterFactory,
        clazz: Class<T>
    ): T =
        createRetrofit(client, converterFactory).create(clazz)

    private fun createRetrofit(
        client: OkHttpClient,
        converterFactory: GsonConverterFactory
    ): Retrofit =
        Retrofit.Builder()
            .addConverterFactory(converterFactory)
            .client(client)
            .baseUrl(LegoApi.BASE_URL)
            .build()

    @Provides
    fun provideOkHttpClient(interceptor: HttpLoggingInterceptor): OkHttpClient =
        OkHttpClient.Builder().addNetworkInterceptor(interceptor).build()

    @Provides
    fun provideLoggingInterceptor() =
        HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }

    @LegoAPI
    @Provides
    fun provideAuthInterceptor(client: OkHttpClient): OkHttpClient =
        client.newBuilder().addInterceptor(AuthInterceptor()).build()

    @Singleton
    @Provides
    fun provideGson(): Gson = Gson()

    @Singleton
    @Provides
    fun provideGsonConverter(gson: Gson): GsonConverterFactory =
        GsonConverterFactory.create(gson)
}