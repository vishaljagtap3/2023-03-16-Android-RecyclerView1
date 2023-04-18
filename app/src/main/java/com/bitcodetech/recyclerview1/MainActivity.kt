package com.bitcodetech.recyclerview1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerCities : RecyclerView
    private val cities = ArrayList<String>()
    private lateinit var citiesAdapter: CitiesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initData()
        initViews()
    }

    private fun initData() {
        for(i in 1..50) {
            cities.add("Pune $i")
        }

        cities.add(1, "Long City Name 123")
        cities.add(6, "Long City Name 123")
        cities.add(12, "Long City Name 123")
        cities.add(9, "Long City Name 123 ******")
        cities.add(19, "Long City Name 123")

    }

    private fun initViews() {
        recyclerCities = findViewById(R.id.recyclerCities);

        citiesAdapter = CitiesAdapter(cities)
        recyclerCities.adapter = citiesAdapter

        /*val linearLayoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL,
            false
        )
        recyclerCities.layoutManager = linearLayoutManager*/

        /*recyclerCities.layoutManager = GridLayoutManager(
            this,
            3
        )*/

        recyclerCities.layoutManager = StaggeredGridLayoutManager(
            3,
            StaggeredGridLayoutManager.VERTICAL
        )
    }
}





