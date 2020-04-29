package com.example.gocorona

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.*
import org.json.JSONArray
import java.io.InputStream

/*This is Hospital Activity */
/*Created by Doulaghar*/

class HospitalActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hospital)
        jsonReaderFunction()
    }   //End onCreate

    private fun jsonReaderFunction(){

        //reference listview
        val hospitalListView = findViewById<ListView>(R.id.hospitalListView)
        var hospitalareaList = arrayListOf<String>()
        var hospitalAdressList = arrayListOf<String>()

        try {
            val inputStream: InputStream = assets.open("hospitals.json")

            var hospitalArray = JSONArray(inputStream.bufferedReader().use { it.readText() })

            for (i in 0 .. hospitalArray.length()-1){
                var hospitalJsonObject = hospitalArray.getJSONObject(i);
                hospitalareaList.add(hospitalJsonObject.getString("area"))
                hospitalAdressList.add(hospitalJsonObject.getString("address"))
            }   //end for.

            hospitalListView.adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_activated_1,hospitalareaList)

            hospitalListView.onItemClickListener = AdapterView.OnItemClickListener{ parent, view, position, id ->

                //reference the text view.
                val addressTextView = findViewById<TextView>(R.id.hospitalTextView)

                val area= hospitalareaList[position]
                val address = hospitalAdressList[position]

                addressTextView.text = area +" residents can visit to the hospital: \n"+ address
            }    //end onItemClick
        } catch (ex:Exception){
            Log.d("LOOK HERE", ex.toString())
            Toast.makeText(this, "Error Occurred : ${ex.toString()} ", Toast.LENGTH_LONG).show()
        }   //End Try-Catch
    }   //End of function jsonReaderFunction
}   //End of class HospitalActivity
