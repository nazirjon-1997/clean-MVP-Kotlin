package com.nazirjon.cleanmvp.ui

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Observer
import com.nazirjon.cleanmvp.R
import com.nazirjon.cleanmvp.domain.entities.Quote
import com.nazirjon.cleanmvp.presenters.quotepresenter.QuotePresenter
import org.koin.androidx.viewmodel.ext.android.viewModel

class QuotesActivity : FragmentActivity() {
    //Lazy injected presenter-viewmodel, if you want to share the same instance with a fragment just change viewModel() to sharedViewModel() in the fragment
    val quotePresenter: QuotePresenter by viewModel()
    private var editTextAuthor: EditText? = null
    private var editTextQuote: EditText? = null
    private var textViewQuotes: TextView? = null
    private var buttonAddQuote: Button? = null
    private var buttonDeleteQuote: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quotes)
        editTextAuthor = findViewById(R.id.editText_author)
        editTextQuote = findViewById(R.id.editText_quote)
        textViewQuotes = findViewById(R.id.textView_quotes)
        buttonAddQuote = findViewById(R.id.button_add_quote)
        buttonDeleteQuote = findViewById(R.id.button_delete_quote)
        initializeUI()
    }

    private fun initializeUI() {
        quotePresenter.getAllQuotes().observe(this, Observer<List<Quote>> { quotes ->
            val stringBuilder = StringBuilder()
            quotes.forEach { quote ->
                stringBuilder.append("$quote\n\n")
            }
            textViewQuotes?.text = stringBuilder.toString()
        })

        buttonAddQuote?.setOnClickListener {
            val quote = Quote(
                null,
                editTextQuote?.text.toString(),
                editTextAuthor?.text.toString()
            )
            quotePresenter.insert(quote)
            editTextQuote?.setText("")
            editTextAuthor?.setText("")
        }

        buttonDeleteQuote?.setOnClickListener { quotePresenter.deleteAllQuotes() }
    }
}
