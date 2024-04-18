package com.example.data.network.model.offers

import com.example.data.network.model.Price

data class OfferResponse(
    val id: Int,
    val price: Price,
    val title: String,
    val town: String
)