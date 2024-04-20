package com.example.domain.model.ticket

data class Ticket(
    val id: Int,
    val badge: String? = null,
    val price: Int,
    val departure: Departure,
    val arrival: Arrival,
    val hasTransfer: Boolean
)
