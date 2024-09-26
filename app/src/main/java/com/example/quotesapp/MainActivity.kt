package com.example.quotesapp

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.example.quotesapp.presentation.viewmodels.QuoteViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: QuoteViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val tvQuote = findViewById<TextView>(R.id.tvQuote)
        val tvAuthor = findViewById<TextView>(R.id.tvAuthor)
        val btnFetchQuote = findViewById<Button>(R.id.btnFetchQuote)

        viewModel = ViewModelProvider(this).get(QuoteViewModel::class.java)

        // Observe the quote LiveData
        viewModel.quote.observe(this) { quote ->
            tvQuote.text = quote.q
            tvAuthor.text = "- ${quote.a}"
        }

        // Fetch new quote on button click
        btnFetchQuote.setOnClickListener {
            viewModel.fetchNewQuote()
        }
    }
}