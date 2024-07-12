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

/**
 * Module pour l'injection de dépendances liées à la base de données.
 * Fournit les instances nécessaires pour l'accès à la base de données et aux DAO.
 */
@Module
@InstallIn(SingletonComponent::class)
internal object DatabaseModule {

    /**
     * Fournit une instance de la base de données principale de l'application.
     * Utilise le contexte de l'application pour construire la base de données.
     *
     * @param appContext Le contexte de l'application Android.
     * @return Une instance de [MainDatabase].
     */
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

    /**
     * Fournit une instance de [NoteDao] pour accéder aux opérations de la base de données sur les notes.
     * Dépend de l'instance de [MainDatabase] fournie par [provideDatabase].
     *
     * @param database L'instance de [MainDatabase] de l'application.
     * @return Une instance de [NoteDao].
     */
    @Singleton
    @Provides
    fun provideNoteDao(database: MainDatabase): NoteDao {
        return database.noteDao()
    }
}