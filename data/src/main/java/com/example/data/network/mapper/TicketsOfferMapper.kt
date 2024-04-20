package com.example.data.network.mapper

import com.example.data.network.model.offerstickets.TicketsOfferDto
import com.example.domain.mapper.Mapper
import com.example.domain.model.TicketsOffer

class TicketsOfferMapper: Mapper<TicketsOfferDto, TicketsOffer> {
    override fun transform(entity: TicketsOfferDto) = TicketsOffer(
        id = entity.id,
        price = entity.price.value,
        title = entity.title,
        timeRange = entity.timeRange
    )
}