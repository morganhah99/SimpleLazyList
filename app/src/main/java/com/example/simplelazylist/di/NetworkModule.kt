package com.example.simplelazylist.di

import com.example.simplelazylist.data.api.APIDetails
import com.example.simplelazylist.data.api.APIEndPoints
import com.example.simplelazylist.data.repository.APIRepository
import com.example.simplelazylist.data.repository.APIRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
class APIModule {

    @Provides
    fun provideRetrofitFactory(): RetrofitFactory {
        return RetrofitFactory()
    }

    @Provides
    fun provideDogImageRetrofit(retrofitFactory: RetrofitFactory): Retrofit {
        return retrofitFactory.createRetrofit(APIDetails.DOG_IMAGE_BASE_URL)
    }

//    @Provides
//    fun provideAnotherServiceRetrofit(retrofitFactory: RetrofitFactory): Retrofit {
//        return retrofitFactory.createRetrofit(APIDetails.ANOTHER_SERVICE_BASE_URL)
//    }

    @Provides
    fun provideDogImageApiEndpoints(retrofit: Retrofit): APIEndPoints {
        return retrofit.create(APIEndPoints::class.java)
    }

//    @Provides
//    fun provideAnotherServiceApiEndpoints(@Named("AnotherServiceRetrofit") retrofit: Retrofit): AnotherServiceAPIEndPoints {
//        return retrofit.create(AnotherServiceAPIEndPoints::class.java)
//    }

    @Provides
    fun provideDogImageRepository(apiEndpoints: APIEndPoints): APIRepository {
        return APIRepositoryImpl(apiEndpoints)
    }

//    @Provides
//    fun provideAnotherServiceRepository(apiEndpoints: AnotherServiceAPIEndPoints): AnotherServiceRepository {
//        return AnotherServiceRepositoryImpl(apiEndpoints)
//    }
}
