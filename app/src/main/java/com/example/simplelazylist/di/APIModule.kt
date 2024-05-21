package com.example.simplelazylist.di

import com.example.simplelazylist.data.api.APIDetails
import com.example.simplelazylist.data.api.APIEndPoints
import com.example.simplelazylist.data.repository.APIRepository
import com.example.simplelazylist.data.repository.APIRepositoryImpl
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
class APIModule {


    @Provides
    fun provideRetroFitInstance(): Retrofit {
        val gson = Gson()
        val gsonConverterFactory = GsonConverterFactory.create(gson)

        val loggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()

        return Retrofit.Builder()
            .baseUrl(APIDetails.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(gsonConverterFactory)
            .build()
    }

    @Provides
    fun provideApiEndpoints(retrofit: Retrofit): APIEndPoints {
        return retrofit.create(APIEndPoints::class.java)
    }

    @Provides
    fun provideRepository(apiEndpoints: APIEndPoints): APIRepository {
        return APIRepositoryImpl(apiEndpoints)
    }

}