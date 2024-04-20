package com.example.data.network.mapper

import com.example.data.network.model.tickets.DepartureDto
import com.example.domain.mapper.Mapper
import com.example.domain.model.ticket.Departure

class DepartureMapper : Mapper<DepartureDto, Departure> {
    override fun transform(entity: DepartureDto) = Departure(
        airport = entity.airport,
        date = entity.date,
        town = entity.town
    )
}