package com.example.testtaskavia.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.Offer
import com.example.domain.model.TicketsOffer
import com.example.domain.usecase.GetOffersUseCase
import com.example.domain.usecase.GetTicketsOfferUseCase
import com.example.domain.utils.Response
import kotlinx.coroutines.launch

class CountrySelectedViewModel (
    private val getTicketsOfferUseCase: GetTicketsOfferUseCase
): ViewModel() {

    private val _ticketsOffers: MutableLiveData<List<TicketsOffer>> = MutableLiveData()
    val ticketsOffers: LiveData<List<TicketsOffer>> = _ticketsOffers

    fun getOffers(){
        viewModelScope.launch {
            val result = getTicketsOfferUseCase.execute()
            when(result){
                is Response.Error -> TODO()
                is Response.Success -> _ticketsOffers.value = (result.data)
            }
        }
    }
}