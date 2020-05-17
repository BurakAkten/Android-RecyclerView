package com.bakten.countryflags

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.country_linear_card_view_layout.view.*
import java.net.URL


class CountryViewAdapter(private val data: Array<Country>, private val context: AppCompatActivity)
    : RecyclerView.Adapter<CountryViewAdapter.DestinationsRecyclerViewViewHolder>() {

    class DestinationsRecyclerViewViewHolder(view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
            : DestinationsRecyclerViewViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.country_linear_card_view_layout, parent, false) as View

        return DestinationsRecyclerViewViewHolder(view)
    }

    override fun onBindViewHolder(holder: DestinationsRecyclerViewViewHolder, position: Int) {
        val country = data[position]
        var countryFlagUrl = """http://flag.muratoner.net/?country=${country.countryCode}"""

        Thread {
            val inputStream = URL(countryFlagUrl).openStream()
            val flagBitmap = BitmapFactory.decodeStream(inputStream)

           context.runOnUiThread{
                holder.itemView.countryNameTextViev.text = country.name
                holder.itemView.countryFlagImageView.setImageBitmap(flagBitmap)
            }
        }.start()
    }

    override fun getItemCount() = data.size
}


