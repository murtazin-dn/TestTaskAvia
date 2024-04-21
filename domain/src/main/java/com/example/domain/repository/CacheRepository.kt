package com.example.domain.repository

interface CacheRepository {
    fun saveFromText(from: String)
    fun getFromText(): String
}