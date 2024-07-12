package com.nazimbo.noteapp.di

import android.content.Context
import androidx.room.Room
import com.nazimbo.noteapp.data.MainDatabase
import com.nazimbo.noteapp.data.dao.NoteDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object DatabaseModule {

    @Provides
    fun provideDatabase(
        @ApplicationContext appContext: Context
    ): MainDatabase {
        val databaseName = "noteapp_database"
        return Room.databaseBuilder(
            appContext,
            MainDatabase::class.java,
            databaseName
        ).build()
    }

    @Singleton
    @Provides
    fun provideNoteDao(database: MainDatabase): NoteDao {
        return database.noteDao()
    }
}