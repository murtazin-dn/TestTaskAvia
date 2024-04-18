package com.example.data.network.repository

import com.example.data.network.model.offers.Offer
import com.example.data.network.model.offers.OffersResponse
import com.example.data.network.model.offers.Price

class OfferService() {
    private val offers = OffersResponse(
        offers = listOf(
            Offer(
                id = 1,
                title = "Die Antwoord",
                town = "Будапешт",
                price = Price(5000)
            ),
            Offer(
                id = 2,
                title = "Socrat&Lera",
                town = "Санкт-Петербур",
                price = Price(1999)
            ),
            Offer(
                id = 3,
                title = "Лампабикт",
                town = "Москва",
                price = Price(2390)
            ),
        )
    )

    suspend fun getOffers(): OffersResponse{
        return offers
    }
}