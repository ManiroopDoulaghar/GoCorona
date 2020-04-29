package com.example.gocorona

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.json.JSONArray
import java.io.InputStream

/*This is facts activity*/
/*Created by Doulaghar*/

class FactsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_facts)

        val factsRecyclerView = findViewById<RecyclerView>(R.id.factsRecyclerView)
        factsRecyclerView.layoutManager = LinearLayoutManager(this,RecyclerView.VERTICAL, false)

        val factsList = ArrayList<FactDataClass>()

        try{
            val inputStream : InputStream = assets.open("facts.json")
            var factsArray = JSONArray(inputStream.bufferedReader().use { it.readText() })
            for (i in 0.. factsArray.length()){
                var factobject = factsArray.getJSONObject(i)
                factsList.add(FactDataClass(factobject.getString("factDesc"),factobject.getString("factExp")))
            }   //end for
        }   catch (e: Exception){
            Log.d("ERROR READING JSON:", e.stackTrace.toString())
        }   //End  Try-Catch

        val factDataAdapter =  FactsAdapterClass(factsList)

        factsRecyclerView.adapter = factDataAdapter
    }   //End onCreate.
}   //End of class FactsActivity

