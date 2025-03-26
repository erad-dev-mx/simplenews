package dev.erad.simplesoftware.di

import android.app.Application
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.erad.simplesoftware.data.manager.LocalUserManagerImpl
import dev.erad.simplesoftware.domain.manager.LocalUserManager
import dev.erad.simplesoftware.domain.use_cases.AppEntryUseCases
import dev.erad.simplesoftware.domain.use_cases.ReadAppEntry
import dev.erad.simplesoftware.domain.use_cases.SaveAppEntry
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