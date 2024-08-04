package com.example.libraryapp.profile.di

import com.example.libraryapp.profile.data.ProfileRepositoryImpl
import com.example.libraryapp.profile.viewmodel.ProfileRepository
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.database
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ProfileModule {

    @Provides
    @Singleton
    fun providesDatabaseReference() = Firebase.database.reference

    /*@Provides
    @Singleton
    fun providesRepositoryImpl(firebaseAuth: FirebaseAuth): ProfileRepository {
        return ProfileRepositoryImpl(firebaseAuth)
    }*/
}