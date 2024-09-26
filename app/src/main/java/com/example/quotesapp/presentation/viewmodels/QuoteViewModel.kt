package com.example.quotesapp.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quotesapp.data.network.RetrofitInstance
import com.example.quotesapp.domain.models.Quote
import kotlinx.coroutines.launch

class QuoteViewModel : ViewModel() {

    private val _quote = MutableLiveData<Quote>()
    val quote: LiveData<Quote> = _quote

    fun fetchNewQuote() {
        viewModelScope.launch {
            val response = RetrofitInstance.api.getRandomQuote()
            _quote.value = response.first()
        }
    }
}