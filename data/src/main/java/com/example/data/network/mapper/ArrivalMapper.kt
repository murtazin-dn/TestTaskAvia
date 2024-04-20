package com.example.data.network.mapper

import com.example.data.network.model.tickets.ArrivalDto
import com.example.domain.mapper.Mapper
import com.example.domain.model.ticket.Arrival

class ArrivalMapper: Mapper<ArrivalDto, Arrival> {
    override fun transform(entity: ArrivalDto) = Arrival (
        airport = entity.airport,
        date = entity.date,
        town = entity.town
    )
}