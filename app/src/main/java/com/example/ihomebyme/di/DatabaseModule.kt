package com.example.ihomebyme.di

import android.content.Context
import androidx.room.Room
import com.example.ihomebyme.db.HomeByMeDatabase
import com.example.ihomebyme.db.dao.ProjectDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, HomeByMeDatabase::class.java, "homebyme").build()


    @Provides
    fun provide(db: HomeByMeDatabase): ProjectDao =
        db.projectDao()

//    @Provides
//    fun provideFundDao(db: HomeByMeDatabase): FundDao =
//        db.fundDao()
}