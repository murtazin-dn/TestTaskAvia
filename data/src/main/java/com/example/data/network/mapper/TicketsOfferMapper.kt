package com.example.data.network.mapper

import com.example.data.network.model.offers.OfferResponse
import com.example.data.network.model.offerstickets.TicketsOfferResponse
import com.example.domain.mapper.Mapper
import com.example.domain.model.Offer
import com.example.domain.model.TicketsOffer

class TicketsOfferMapper: Mapper<TicketsOfferResponse, TicketsOffer> {
    override fun transform(entity: TicketsOfferResponse) = TicketsOffer(
        id = entity.id,
        price = entity.price.value,
        title = entity.title,
        timeRange = entity.timeRange
    )
}