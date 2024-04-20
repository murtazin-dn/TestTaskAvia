package com.example.data.network.model.offerstickets

import com.example.data.network.model.Price

data class TicketsOfferDto(
    val id: Int,
    val price: Price,
    val timeRange: List<String>,
    val title: String
)