package com.example.gocorona

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.json.JSONArray
import java.io.InputStream

//Created by Doulaghar

class FactsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_facts)

        //referencing the recycler view.
        //RecyclerView involves three steps
        //1.Reference the view
        //2.define the layout as vertical or horizontal, using the layout manager.
        //3.Create an adapter for the RV, inorder to render the view and bind data
        //4.Assign the dataadapter to the RV.

        val factsRecyclerView = findViewById<RecyclerView>(R.id.factsRecyclerView)
        factsRecyclerView.layoutManager = LinearLayoutManager(this,RecyclerView.VERTICAL, false)
        //Recycler view data comes from a list, which can comprise of several parts for each item. So each item can have multiple
        //inner views (Text views in our case)

        //The data for RV comes from PotterQuotes.json inside the assests folder. We need to get the data into the potterQuoteslist.
        val factsList = ArrayList<FactDataClass>()

        //ALways have the JSON handling inside a try catch block to handle errors.
        try{
            val inputStream : InputStream = assets.open("facts.json")
            var factsArray = JSONArray(inputStream.bufferedReader().use { it.readText() })     //get the file as an array
            for (i in 0.. factsArray.length()){
                var factobject = factsArray.getJSONObject(i)
                factsList.add(FactDataClass(factobject.getString("factDesc"),factobject.getString("factExp")))
            }   //end for
        }   catch (e: Exception){
            //display the error.
            Log.d("ERROR READING JSON:", e.stackTrace.toString())
        }   //end  Try-Catch

        val factDataAdapter =  FactsAdapterClass(factsList)

        factsRecyclerView.adapter = factDataAdapter
    }   //end onCreate.
}   //end MainActivity class.

