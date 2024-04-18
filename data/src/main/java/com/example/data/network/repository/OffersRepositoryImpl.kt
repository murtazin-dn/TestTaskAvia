package com.example.data.network.repository

import com.example.domain.mapper.Mapper
import com.example.domain.model.Offer
import com.example.domain.repository.OffersRepository
import com.example.domain.utils.Response
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class OffersRepositoryImpl @Inject constructor(
    private val offerService: OfferService,
    private val offerMapper: Mapper<com.example.data.network.model.offers.Offer, Offer>
): OffersRepository {
    override suspend fun getOffers(): Response<List<Offer>> = withContext(Dispatchers.IO){
        val response = offerService.getOffers()
        //if(response.isSuccess)
        return@withContext Response.Success(response.offers.map { offerMapper.transform(it) })
    }
}