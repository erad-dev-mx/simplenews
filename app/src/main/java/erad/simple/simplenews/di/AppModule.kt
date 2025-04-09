package erad.simple.simplenews.di

import android.app.Application
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import erad.simple.simplenews.data.manager.LocalUserManagerImpl
import erad.simple.simplenews.data.remote.NewsApi
import erad.simple.simplenews.data.repository.NewsRepositoryImpl
import erad.simple.simplenews.domain.manager.LocalUserManager
import erad.simple.simplenews.domain.repository.NewsRepository
import erad.simple.simplenews.domain.use_cases.app_entry.AppEntryUseCases
import erad.simple.simplenews.domain.use_cases.app_entry.ReadAppEntry
import erad.simple.simplenews.domain.use_cases.app_entry.SaveAppEntry
import erad.simple.simplenews.domain.use_cases.news.GetNews
import erad.simple.simplenews.domain.use_cases.news.NewsUseCases
import erad.simple.simplenews.util.Constants.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideLocalUserManager(
        application: Application
    ): LocalUserManager = LocalUserManagerImpl(application)

    @Provides
    @Singleton
    fun providesAppEntryUseCases(
        localUserManager: LocalUserManager
    ) = AppEntryUseCases(
        readAppEntry = ReadAppEntry(localUserManager),
        saveAppEntry = SaveAppEntry(localUserManager)
    )

    @Provides
    @Singleton
    fun providesNewsApi(): NewsApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewsApi::class.java)
    }

    @Provides
    @Singleton
    fun provideNewsRepository(
        newsApi: NewsApi
    ): NewsRepository = NewsRepositoryImpl(newsApi)

    @Provides
    @Singleton
    fun provideNewsUseCases(newsRepository: NewsRepository): NewsUseCases {
        return NewsUseCases(
            getNews = GetNews(newsRepository)
        )
    }
}