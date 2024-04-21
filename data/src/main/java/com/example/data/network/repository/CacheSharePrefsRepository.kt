package com.example.data.network.repository

import android.content.Context
import android.content.SharedPreferences
import com.example.domain.repository.CacheRepository
import javax.inject.Inject

class CacheSharePrefsRepository @Inject constructor(
    private val context: Context
): CacheRepository {
    private val preferences: SharedPreferences =
        context.getSharedPreferences("WeatherPrefs", Context.MODE_PRIVATE)

    override fun saveFromText(from: String) {
        preferences
            .edit()
            .putString(FROM_TEXT, from)
            .apply()
    }

    override fun getFromText(): String {
        return preferences.getString(FROM_TEXT, "") ?: ""
    }

    companion object{
        private const val FROM_TEXT = "from_text"
    }



}