package com.example.gocorona

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.*
import org.json.JSONArray
import java.io.InputStream

class HospitalActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hospital)
        jsonReaderFunction()
    }
    private fun jsonReaderFunction(){

        //reference listview
        val hospitalListView = findViewById<ListView>(R.id.hospitalListView)
        //two seperate lists for roles and actors
        var hospitalareaList = arrayListOf<String>()
        var hospitalAdressList = arrayListOf<String>()

        //trying to read json. Always use try/catch for error handling.
        try {
            val inputStream: InputStream = assets.open("hospitals.json")

            //read the json file into an array
            var hospitalArray = JSONArray(inputStream.bufferedReader().use { it.readText() })
            //traverse through the array and fill the actor and role lists.
            for (i in 0 .. hospitalArray.length()-1){
                var hospitalJsonObject = hospitalArray.getJSONObject(i);
                hospitalareaList.add(hospitalJsonObject.getString("area"))     //this will be displayed in the listview.
                hospitalAdressList.add(hospitalJsonObject.getString("address"))   //this list is used to display the actor inside textView when user  selects the role.
            }   //end for.

            //once the lists are ready, put the rold list inside the adapter and bind to list.
            hospitalListView.adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_activated_1,hospitalareaList)

            //when the user clicks on the list item : event listener to show the actor for the rold selected.
            hospitalListView.onItemClickListener = AdapterView.OnItemClickListener{ parent, view, position, id ->
                //incoming arguments are parent(recycler view), View(tv), position(index in the list), and id.

                //reference the text view.
                val actorTextView = findViewById<TextView>(R.id.hospitalTextView)

                //get the role selected. & actor selected.
                val area= hospitalareaList[position]
                val address = hospitalAdressList[position]

                //display the results inside textview.
                actorTextView.text = area +" residents can visit to the hospital: \n"+ address
            }    //end onItemClick
        } catch (ex:Exception){
            Log.d("LOOK HERE", ex.toString())
            Toast.makeText(this, "Error Occurred : ${ex.toString()} ", Toast.LENGTH_LONG).show()
        }   //end Try-Catch
    }
}
