package com.bogatovnikita.ridechronicles.di

import com.bogatovnikita.ridechronicles.data.repository.ListOfCarRepositoryImpl
import com.bogatovnikita.ridechronicles.data.repository.ListOfPostsRepositoryImpl
import com.bogatovnikita.ridechronicles.data.repository.SomeCarRepositoryImpl
import com.bogatovnikita.ridechronicles.domain.repository.ListOfCarRepository
import com.bogatovnikita.ridechronicles.domain.repository.ListOfPostsRepository
import com.bogatovnikita.ridechronicles.domain.repository.SomeCarRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RepositoriesModuleDependencies {

    @Binds
    fun bindListOfCarRepositoryToListOfCarRepositoryImpl(listOfCarRepository: ListOfCarRepositoryImpl): ListOfCarRepository

    @Binds
    fun bindListOfPostsRepositoryToListOfPostsRepositoryImpl(listOfPostsRepository: ListOfPostsRepositoryImpl): ListOfPostsRepository

    @Binds
    fun bindSomeCarRepositoryToSomeCarRepositoryImpl(someCarRepository: SomeCarRepositoryImpl): SomeCarRepository
}