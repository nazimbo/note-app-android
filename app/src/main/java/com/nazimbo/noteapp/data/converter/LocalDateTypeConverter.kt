package com.nazimbo.noteapp.data.converter

import androidx.room.TypeConverter
import java.time.LocalDateTime

/**
 * Convertisseur de type pour Room permettant la conversion entre les chaînes de caractères et les instances de LocalDateTime.
 * Ceci est nécessaire car Room ne supporte pas directement les instances de LocalDateTime dans les entités de base de données.
 */
class LocalDateTypeConverter {

    /**
     * Convertit une chaîne de caractères en une instance de LocalDateTime.
     *
     * @param dateString La chaîne de caractères représentant la date et l'heure, peut être null.
     * @return L'instance de LocalDateTime correspondante, ou null si la chaîne d'entrée est null.
     */
    @TypeConverter
    fun toLocalDateTime(dateString: String?): LocalDateTime? {
        return dateString?.let { LocalDateTime.parse(it) }
    }

    /**
     * Convertit une instance de LocalDateTime en une chaîne de caractères.
     *
     * @param date L'instance de LocalDateTime à convertir, peut être null.
     * @return La chaîne de caractères représentant la date et l'heure, ou null si l'instance de LocalDateTime est null.
     */
    @TypeConverter
    fun localDateTimetoString(date: LocalDateTime?): String? {
        return date?.toString()
    }
}