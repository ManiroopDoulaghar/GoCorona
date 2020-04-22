package com.example.gocorona

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity

import kotlinx.android.synthetic.main.activity_dashboard.*

class DashboardActivity : AppCompatActivity() {

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

    }
}
