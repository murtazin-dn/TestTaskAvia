package com.example.data.network.repository

import com.example.data.network.model.offers.OfferDto
import com.example.data.network.model.offers.OffersDto
import com.example.data.network.model.Price
import com.example.data.network.model.offerstickets.TicketsOfferDto
import com.example.data.network.model.offerstickets.TicketsOffersDto
import com.example.data.network.model.tickets.ArrivalDto
import com.example.data.network.model.tickets.DepartureDto
import com.example.data.network.model.tickets.HandLuggageDto
import com.example.data.network.model.tickets.LuggageDto
import com.example.data.network.model.tickets.TicketDto
import com.example.data.network.model.tickets.TicketsDto
import kotlinx.coroutines.delay

class OfferService() {

    suspend fun getOffers(): OffersDto {
        delay(100)
        return offers
    }

    suspend fun getTicketsOffers(): TicketsOffersDto {
        delay(100)
        return ticketsOffers
    }

    suspend fun getTickets(): TicketsDto {
        delay(100)
        return tickets
    }


    private val tickets = TicketsDto(
        tickets = listOf(
            TicketDto(
                id = 100,
                badge = "Самый удобный",
                price = Price(5000),
                providerName = "На сайте Купибилет",
                company = "Якутия",
                departure = DepartureDto(
                    town = "Москва",
                    date = "2024-02-23T03:15:00",
                    airport = "VKO"
                ),
                arrival = ArrivalDto(
                    town = "Сочи",
                    date = "2024-02-23T07:10:00",
                    airport = "AER"
                ),
                hasTransfer = false,
                hasVisaTransfer = false,
                luggage = LuggageDto(
                    has_luggage = false,
                    price = Price(1082),
                ),
                handLuggage = HandLuggageDto(
                    hasHandLuggage = true,
                    size = "55x20x40"
                ),
                isReturnable = false,
                isExchangable = true
            ),
            TicketDto(
                id = 101,
                badge = "Самый удобный",
                price = Price(9999),
                providerName = "На сайте Победа",
                company = "Победа",
                departure = DepartureDto(
                    town = "Москва",
                    date = "2024-02-23T04:00:00",
                    airport = "VKO"
                ),
                arrival = ArrivalDto(
                    town = "Сочи",
                    date = "2024-02-23T08:30:00",
                    airport = "AER"
                ),
                hasTransfer = false,
                hasVisaTransfer = false,
                luggage = LuggageDto(
                    has_luggage = false,
                    price = Price(1602),
                ),
                handLuggage = HandLuggageDto(
                    hasHandLuggage = true,
                    size = "36x30x27"
                ),
                isReturnable = false,
                isExchangable = true
            ),
            TicketDto(
                id = 102,
                price = Price(8500),
                providerName = "На сайте Turkish Airlines",
                company = "Турецкие авиалинии",
                departure = DepartureDto(
                    town = "Москва",
                    date = "2024-02-23T15:00:00",
                    airport = "VKO"
                ),
                arrival = ArrivalDto(
                    town = "Сочи",
                    date = "2024-02-23T18:40:00",
                    airport = "AER"
                ),
                hasTransfer = false,
                hasVisaTransfer = false,
                luggage = LuggageDto(
                    has_luggage = true
                ),
                handLuggage = HandLuggageDto(
                    hasHandLuggage = true,
                    size = "55x20x40"
                ),
                isReturnable = false,
                isExchangable = false
            ),
            TicketDto(
                id = 103,
                badge = "Рекомендуемый",
                price = Price(8086),
                providerName = "На сайте Уральские авиалинии",
                company = "Уральские авиалинии",
                departure = DepartureDto(
                    town = "Москва",
                    date = "2024-02-23T11:30:00",
                    airport = "VKO"
                ),
                arrival = ArrivalDto(
                    town = "Сочи",
                    date = "2024-02-23T15:00:00",
                    airport = "AER"
                ),
                hasTransfer = false,
                hasVisaTransfer = false,
                luggage = LuggageDto(
                    has_luggage = false,
                    price = Price(1570),
                ),
                handLuggage = HandLuggageDto(
                    hasHandLuggage = true,
                    size = "55x20x40"
                ),
                isReturnable = true,
                isExchangable = true
            ),
            TicketDto(
                id = 104,
                price = Price(11560),
                providerName = "На сайте Aeroflot",
                company = "Аэрофлот",
                departure = DepartureDto(
                    town = "Москва",
                    date = "2024-02-23T11:50:00",
                    airport = "VKO"
                ),
                arrival = ArrivalDto(
                    town = "Сочи",
                    date = "2024-02-23T15:20:00",
                    airport = "AER"
                ),
                hasTransfer = true,
                hasVisaTransfer = false,
                luggage = LuggageDto(
                    has_luggage = false,
                    price = Price(999),
                ),
                handLuggage = HandLuggageDto(
                    hasHandLuggage = true,
                    size = "55x20x40"
                ),
                isReturnable = false,
                isExchangable = true
            ),
            TicketDto(
                id = 105,
                price = Price(15600),
                providerName = "На сайте Aeroflot",
                company = "Аэрофлот",
                departure = DepartureDto(
                    town = "Москва",
                    date = "2024-02-23T13:50:00",
                    airport = "VKO"
                ),
                arrival = ArrivalDto(
                    town = "Сочи",
                    date = "2024-02-23T17:20:00",
                    airport = "AER"
                ),
                hasTransfer = true,
                hasVisaTransfer = true,
                luggage = LuggageDto(
                    has_luggage = false,
                    price = Price(1999),
                ),
                handLuggage = HandLuggageDto(
                    hasHandLuggage = true,
                    size = "55x20x40"
                ),
                isReturnable = true,
                isExchangable = true
            ),
            TicketDto(
                id = 106,
                price = Price(9500),
                providerName = "На сайте Aeroflot",
                company = "Аэрофлот",
                departure = DepartureDto(
                    town = "Москва",
                    date = "2024-02-23T21:00:00",
                    airport = "VKO"
                ),
                arrival = ArrivalDto(
                    town = "Сочи",
                    date = "2024-02-24T00:20:00",
                    airport = "AER"
                ),
                hasTransfer = false,
                hasVisaTransfer = false,
                luggage = LuggageDto(
                    has_luggage = false,
                    price = Price(5999),
                ),
                handLuggage = HandLuggageDto(
                    hasHandLuggage = false
                ),
                isReturnable = false,
                isExchangable = true
            ),

        )
    )

    private val offers = OffersDto(
        offers = listOf(
            OfferDto(
                id = 1,
                title = "Die Antwoord",
                town = "Будапешт",
                price = Price(5000)
            ),
            OfferDto(
                id = 2,
                title = "Socrat&Lera",
                town = "Санкт-Петербур",
                price = Price(1999)
            ),
            OfferDto(
                id = 3,
                title = "Лампабикт",
                town = "Москва",
                price = Price(2390)
            ),
        )
    )

    private val ticketsOffers = TicketsOffersDto(
        ticketsOffers = listOf(
            TicketsOfferDto(
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
            TicketsOfferDto(
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
            TicketsOfferDto(
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