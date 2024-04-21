package com.example.testtaskavia.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.Offer
import com.example.domain.usecase.GetFromTextUseCase
import com.example.domain.usecase.GetOffersUseCase
import com.example.domain.usecase.SaveFromTextUseCase
import com.example.domain.utils.Response
import kotlinx.coroutines.launch

class AirTicketsViewModel(
    private val getOffersUseCase: GetOffersUseCase,
    private val getFromTextUseCase: GetFromTextUseCase,
    private val saveFromTextUseCase: SaveFromTextUseCase
) : ViewModel() {

    private val _offers: MutableLiveData<List<Offer>> = MutableLiveData()
    val offers: LiveData<List<Offer>> = _offers
    private val _fromText: MutableLiveData<String> = MutableLiveData()
    val fromText: LiveData<String> = _fromText

    fun getOffers(){
        viewModelScope.launch {
            val result = getOffersUseCase.execute()
            when(result){
                is Response.Error -> TODO()
                is Response.Success -> _offers.value = (result.data)
            }
        }
    }

    fun getFromText(){
        _fromText.value = getFromTextUseCase.execute()
    }

    fun saveFromText(text: String){
        saveFromTextUseCase.execute(text)
    }
}