package erad.simple.simplenews.di

import android.app.Application
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import erad.simple.simplenews.data.manager.LocalUserManagerImpl
import erad.simple.simplenews.domain.manager.LocalUserManager
import erad.simple.simplenews.domain.use_cases.app_entry.AppEntryUseCases
import erad.simple.simplenews.domain.use_cases.app_entry.ReadAppEntry
import erad.simple.simplenews.domain.use_cases.app_entry.SaveAppEntry
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
}