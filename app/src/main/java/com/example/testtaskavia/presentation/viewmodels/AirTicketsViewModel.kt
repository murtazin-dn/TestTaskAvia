package com.example.testtaskavia.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.Offer
import com.example.domain.usecase.GetOffersUseCase
import com.example.domain.utils.Response
import kotlinx.coroutines.launch

class AirTicketsViewModel(
    private val getOffersUseCase: GetOffersUseCase
) : ViewModel() {

    private val _offers: MutableLiveData<List<Offer>> = MutableLiveData()
    val offers: LiveData<List<Offer>> = _offers

    fun getOffers(){
        viewModelScope.launch {
            val result = getOffersUseCase.execute()
            when(result){
                is Response.Error -> TODO()
                is Response.Success -> _offers.value = (result.data)
            }
        }
    }
}