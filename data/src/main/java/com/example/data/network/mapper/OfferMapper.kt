package com.example.data.network.mapper

import com.example.data.network.model.offers.OfferResponse
import com.example.domain.mapper.Mapper
import com.example.domain.model.Offer

class OfferMapper: Mapper<OfferResponse, Offer> {
    override fun transform(entity: OfferResponse) = Offer(
        id = entity.id,
        price = entity.price.value,
        title = entity.title,
        town = entity.town
    )
}