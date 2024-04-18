package com.example.domain.repository

import com.example.domain.model.Offer
import com.example.domain.utils.Response

interface OffersRepository {
    suspend fun getOffers(): Response<List<Offer>>
}