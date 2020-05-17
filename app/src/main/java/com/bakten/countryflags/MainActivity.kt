package com.bakten.countryflags

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var CountryViewAdapter: RecyclerView.Adapter<*>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val countries = Countries().getAllCountries()
        CountryViewAdapter = CountryViewAdapter(countries, this@MainActivity)

        linearCountriesRecyclerView.apply {
            setHasFixedSize(true)
            adapter = CountryViewAdapter

        }
    }
}
