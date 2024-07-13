package com.nazimbo.noteapp.di

import com.nazimbo.noteapp.data.repository.NoteRepository
import com.nazimbo.noteapp.data.repository.NoteRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Module pour l'injection de dépendances liées au repository des notes.
 * Déclare les liaisons entre les interfaces de repository et leurs implémentations.
 */
@Module
@InstallIn(SingletonComponent::class)
internal abstract class AppModule {

    /**
     * Fournit l'implémentation de [NoteRepository].
     * Lie l'implémentation [NoteRepositoryImpl] à l'interface [NoteRepository].
     *
     * @param impl L'implémentation de [NoteRepositoryImpl].
     * @return L'instance de [NoteRepository] utilisée dans l'application.
     */
    @Singleton
    @Binds
    abstract fun bindNoteRepository(impl: NoteRepositoryImpl): NoteRepository
}