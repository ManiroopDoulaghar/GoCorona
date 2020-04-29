package com.example.gocorona

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

/*This is Dashboard Activity*/
/*Created by Doulaghar*/

import kotlinx.android.synthetic.main.activity_dashboard.*

class DashboardActivity : AppCompatActivity() {

    var gcAuth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
        setSupportActionBar(toolbar)

        /*Start of Hospital Module*/

        //reference HospitalImageClick
        val hospitalImageView = findViewById<ImageView>(R.id.hospitals)

        //Image onClick Listener
        hospitalImageView.setOnClickListener {
            val hospitalIntent = Intent(this,HospitalActivity::class.java)
            startActivity(hospitalIntent)
        }

        /*End of Hospital Module*/

        /*Start of Report Module*/

        //reference ReportImageClick
        val reportImageView = findViewById<ImageView>(R.id.report)

        //Image onClick Listener
        reportImageView.setOnClickListener {
            val reportIntent = Intent(this,ReportActivity::class.java)
            startActivity(reportIntent)
        }

        /*Start of COVID-19 Facts*/

        //reference COVID-19ImageClick
        val factsImageView = findViewById<ImageView>(R.id.facts)

        //Image onClickListener
        factsImageView.setOnClickListener {
            val factsIntent = Intent(this,FactsActivity::class.java)
            startActivity(factsIntent)
        }

        /*End of COVID-19 Module*/

        /*Start of Infect-Check Facts*/

        //reference infectCheck ImageClick
        val infectCheckImageView = findViewById<ImageView>(R.id.infectCheck)

        //Image onClickListener
        infectCheck.setOnClickListener {
            val infectCheckIntent = Intent(this,InfectCheck::class.java)
            startActivity(infectCheckIntent)
        }
        /*End of infectCheck Module*/

        /*Start of Signout
        * Note: This is not an activity*/

        //reference the Sign out Button click
        val btn_logout = findViewById<Button>(R.id.btn_LogOut)

        //Button onClickListener
        btn_logout.setOnClickListener {
            gcAuth.signOut()
        }
        gcAuth.addAuthStateListener {
            if (gcAuth.currentUser == null) {
                this.finish()
                val mainActivityIntent = Intent(this,MainActivity::class.java)
                startActivity(mainActivityIntent)
            }
        }   //addAuthStateListener
        /*End of Signout*/
    }   //End onCreate
}   //End of Dashboard Activity class
