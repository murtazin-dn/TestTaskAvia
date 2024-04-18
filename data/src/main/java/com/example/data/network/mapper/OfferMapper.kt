package com.example.data.network.mapper

import com.example.data.network.model.offers.Offer
import com.example.data.network.utils.formatNumberWithSpaces
import com.example.domain.mapper.Mapper

class OfferMapper: Mapper<Offer, com.example.domain.model.Offer> {
    override fun transform(entity: Offer) = com.example.domain.model.Offer(
        id = entity.id,
        price = formatNumberWithSpaces(entity.price.value),
        title = entity.title,
        town = entity.town
    )
}