package com.example.gocorona


import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity

import kotlinx.android.synthetic.main.activity_infect_check.*

/*This is Infect Check Activity*/
/*Created by Doulaghar*/

class InfectCheck : AppCompatActivity(), Communicator {

    val fragmentManager =supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_infect_check)

        val transaction= fragmentManager.beginTransaction()

        val infectCheckFragment = InfectCheckFragment()

        transaction.replace(R.id.fragmentHolder, infectCheckFragment,"InfectCheckFragment")
        transaction.addToBackStack(null)
        transaction.commit()
    }   //end onCreate

     override fun passData(resultText:String){

        val bundle = Bundle()
        bundle.putString("resultIFCheck",resultText)

        val transaction = fragmentManager.beginTransaction()

        val infectResultCheckFragment = InfectCheckResult()

         infectResultCheckFragment.arguments =bundle
         transaction.replace(R.id.fragmentHolder,infectResultCheckFragment,"InfectCheckResult").addToBackStack(null).commit()
     }  //End of passData function
}   //End of InfectCheck Activity
