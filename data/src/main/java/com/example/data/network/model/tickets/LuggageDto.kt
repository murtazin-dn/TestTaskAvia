package com.example.data.network.model.tickets

import com.example.data.network.model.Price

data class LuggageDto(
    val has_luggage: Boolean,
    val price: Price? = null
)