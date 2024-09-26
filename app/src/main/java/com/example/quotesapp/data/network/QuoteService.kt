package com.example.quotesapp.data.network


import com.example.quotesapp.domain.models.Quote
import retrofit2.http.GET

interface QuoteService {
    @GET("random")
    suspend fun getRandomQuote(): List<Quote>
}