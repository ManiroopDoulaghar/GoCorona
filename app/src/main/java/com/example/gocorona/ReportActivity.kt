package com.example.gocorona

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_dashboard.*

/*This is report Activity*/
/*Created by Doulaghar*/

class ReportActivity : AppCompatActivity() {

    lateinit var editTextName : EditText
    lateinit var editMobileNumber : EditText
    lateinit var genderSelection : Spinner
    lateinit var editSymptoms: EditText
    lateinit var checkbox : CheckBox
    lateinit var reportButton : Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_report)
        setSupportActionBar(toolbar)

        editTextName = findViewById(R.id.ReportTextName)
        editMobileNumber = findViewById(R.id.ReportMobileNumber)
        genderSelection = findViewById(R.id.GenderSelection)
        editSymptoms = findViewById(R.id.EditText)
        checkbox = findViewById(R.id.CheckBoxResponse)
        reportButton = findViewById(R.id.Buttonreport)

        reportButton.setOnClickListener {
            saveData()
        }
    }   //End onCreate

    private fun saveData() {
        val Name = editTextName.text.toString().trim()
        val MobileNumber = editMobileNumber.text.toString().trim()
        val Gender = genderSelection.selectedItem.toString()
        val Symptoms = editSymptoms.text.toString().trim()
        val CheckboxValue = checkbox.isChecked

        if(Name!="" && MobileNumber!="" && Gender!="" && Symptoms!="") {
            try {
                val ref = FirebaseDatabase.getInstance().getReference("Report")
                val reportId = ref.push().key
                val reportCase = Report(reportId, Name, MobileNumber,Gender ,Symptoms ,CheckboxValue)
                if (reportId != null) {
                    ref.child(reportId).setValue(reportCase).addOnCompleteListener{
                        Toast.makeText(applicationContext,"Report Saved Successfully",Toast.LENGTH_LONG).show()
                    }
                }
            } catch (ex:Exception){
                Log.d("LOOK HERE", ex.toString())
            }
        }
        else{
            Toast.makeText(applicationContext,"Please Fill the form correctly.",Toast.LENGTH_LONG).show()
        }   //End of if-Check
    }   //End of function saveData()
}   //End of class ReportActivity
