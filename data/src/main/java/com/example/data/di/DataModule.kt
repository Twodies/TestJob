package com.example.data.di

import com.example.data.repository.HomeRepositoryImpl
import com.example.data.repository.SearchRepositoryImpl
import com.example.data.repository.TicketRepositoryImpl
import com.example.domain.repository.RepositoryHome
import com.example.domain.repository.RepositorySearch
import com.example.domain.repository.RepositoryTicket
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    @Singleton
    fun provideHomeRepository(homeRepositoryImpl: HomeRepositoryImpl): RepositoryHome {
        return homeRepositoryImpl
    }

    @Provides
    @Singleton
    fun provideSearchRepository(searchRepositoryImpl: SearchRepositoryImpl): RepositorySearch {
        return searchRepositoryImpl
    }

    @Provides
    @Singleton
    fun provideTicketRepository(ticketRepositoryImpl: TicketRepositoryImpl): RepositoryTicket {
        return ticketRepositoryImpl
    }

}
