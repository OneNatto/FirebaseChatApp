package com.example.firebasechatapp.di

import com.example.firebasechatapp.data.auth.FirebaseAuthRepositoryImpl
import com.example.firebasechatapp.data.auth.FirebaseAuthService
import com.example.firebasechatapp.data.firestore.FirestoreRepositoryImpl
import com.example.firebasechatapp.data.firestore.FirestoreService
import com.example.firebasechatapp.ui.auth.FirebaseAuthRepository
import com.example.firebasechatapp.ui.chat.FirestoreRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideFirebaseAuthService(): FirebaseAuthService{
        return FirebaseAuthService()
    }

    @Provides
    @Singleton
    fun provideFirestoreService(): FirestoreService{
        return FirestoreService()
    }

    @Provides
    @Singleton
    fun provideFirebaseAuthRepository(authService: FirebaseAuthService): FirebaseAuthRepository{
        return FirebaseAuthRepositoryImpl(authService)
    }

    @Provides
    @Singleton
    fun provideFirestoreRepository(firestoreService: FirestoreService): FirestoreRepository {
        return FirestoreRepositoryImpl(firestoreService)
    }
}