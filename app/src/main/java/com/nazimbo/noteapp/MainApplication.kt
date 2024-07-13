package com.nazimbo.noteapp

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

/**
 * Application principale pour NoteApp.
 * Configure Dagger-Hilt pour l'injection de dépendance au niveau de l'application.
 */
@HiltAndroidApp
class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()
    }
}