package com.example.data.network.model.offers

data class Offer(
    val id: Int,
    val price: Price,
    val title: String,
    val town: String
)