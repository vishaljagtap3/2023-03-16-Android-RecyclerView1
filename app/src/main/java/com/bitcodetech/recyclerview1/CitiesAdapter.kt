package com.bitcodetech.recyclerview1

import android.graphics.Color
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.view.marginBottom
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import kotlin.random.Random

class CitiesAdapter(
    private val cities : ArrayList<String>
) : RecyclerView.Adapter<CitiesAdapter.CityViewHolder>() {

    var countOfOnCreate = 0

    class CityViewHolder(val txtCity : TextView) : ViewHolder(txtCity)


    override fun getItemCount() = cities.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CityViewHolder {

        Log.e("tag", "onCreateViewHolder ${++countOfOnCreate}")

        val random = Random(System.currentTimeMillis())

        val txtCity = TextView(parent.context)
        txtCity.layoutParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        txtCity.textSize = 25F
        txtCity.setPadding(10, 10, 10, 10)
        txtCity.setTextColor(Color.WHITE)
        txtCity.setBackgroundColor(
            Color.rgb(
                Math.abs(random.nextInt() % 255),
                Math.abs(random.nextInt() % 255),
                Math.abs(random.nextInt() % 255)
            )
        )

        return CityViewHolder(txtCity)

    }

    override fun onBindViewHolder(holder: CityViewHolder, position: Int) {
        //holder.txtCity.text = cities[position]
        holder.txtCity.append(" | " + cities[position])
    }



}