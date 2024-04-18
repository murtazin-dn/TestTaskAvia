package com.example.data.network.repository

import com.example.data.network.model.offers.OfferResponse
import com.example.data.network.model.offers.OffersResponse
import com.example.data.network.model.Price
import com.example.data.network.model.offerstickets.TicketsOfferResponse
import com.example.data.network.model.offerstickets.TicketsOffersResponse
import kotlinx.coroutines.delay

class OfferService() {

    suspend fun getOffers(): OffersResponse {
        delay(100)
        return offers
    }
    suspend fun getTicketsOffers(): TicketsOffersResponse {
        delay(100)
        return ticketsOffers
    }


    private val offers = OffersResponse(
        offers = listOf(
            OfferResponse(
                id = 1,
                title = "Die Antwoord",
                town = "Будапешт",
                price = Price(5000)
            ),
            OfferResponse(
                id = 2,
                title = "Socrat&Lera",
                town = "Санкт-Петербур",
                price = Price(1999)
            ),
            OfferResponse(
                id = 3,
                title = "Лампабикт",
                town = "Москва",
                price = Price(2390)
            ),
        )
    )

    private val ticketsOffers = TicketsOffersResponse(
        ticketsOffers = listOf(
            TicketsOfferResponse(
                id = 1,
                title = "Уральские авиалинии",
                timeRange = listOf(
                    "07:00",
                    "09:10",
                    "10:00",
                    "11:30",
                    "14:15",
                    "19:10",
                    "21:00",
                    "23:30"
                ),
                price = Price(
                    value = 3999
                )
            ),
            TicketsOfferResponse(
                id = 10,
                title = "Победа",
                timeRange = listOf(
                    "09:10",
                    "21:00"
                ),
                price = Price(
                    value = 4999
                )
            ),
            TicketsOfferResponse(
                id = 30,
                title = "NordStar",
                timeRange = listOf(
                    "07:00"
                ),
                price = Price(
                    value = 2399
                )
            )

        )
    )
}