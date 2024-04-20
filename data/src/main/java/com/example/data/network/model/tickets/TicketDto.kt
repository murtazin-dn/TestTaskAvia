package com.example.data.network.model.tickets

import com.example.data.network.model.Price

data class TicketDto(
    val arrival: ArrivalDto,
    val badge: String? = null,
    val company: String,
    val departure: DepartureDto,
    val handLuggage: HandLuggageDto,
    val hasTransfer: Boolean,
    val hasVisaTransfer: Boolean,
    val id: Int,
    val isExchangable: Boolean,
    val isReturnable: Boolean,
    val luggage: LuggageDto,
    val price: Price,
    val providerName: String
)