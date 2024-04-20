package com.example.data.network.mapper

import com.example.data.network.model.tickets.ArrivalDto
import com.example.data.network.model.tickets.DepartureDto
import com.example.data.network.model.tickets.TicketDto
import com.example.domain.mapper.Mapper
import com.example.domain.model.ticket.Arrival
import com.example.domain.model.ticket.Departure
import com.example.domain.model.ticket.Ticket
import javax.inject.Inject

class TicketMapper @Inject constructor(
    private val arrivalMapper: Mapper<ArrivalDto, Arrival>,
    private val departureMapper: Mapper<DepartureDto, Departure>
): Mapper<TicketDto, Ticket> {
    override fun transform(entity: TicketDto) = Ticket (
        id = entity.id,
        badge = entity.badge,
        price = entity.price.value,
        hasTransfer = entity.hasTransfer,
        departure = departureMapper.transform(entity.departure),
        arrival = arrivalMapper.transform(entity.arrival)
    )
}