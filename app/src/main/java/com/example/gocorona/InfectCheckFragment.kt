package com.example.gocorona

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox

/*This is first fragment of Infect Check*/
/*Created by Doulaghar*/

class InfectCheckFragment : Fragment() {

    lateinit var comm: Communicator     //Initiator of Communicator Interface.

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_infect_check, container, false)
    }   //End oncreate

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //reference the InfectCheck Submit Button
        val ifCheckSubmit = view.findViewById<Button>(R.id.button)

        comm = activity as Communicator

        //setonClickListener for the InfectCheck Submit Button
        ifCheckSubmit.setOnClickListener {
            val ch_Sorethroat = view.findViewById<CheckBox>(R.id.Sorethroat)
            val ch_Fever = view.findViewById<CheckBox>(R.id.Fever)
            val ch_ShortOfBreath = view.findViewById<CheckBox>(R.id.ShortOfBreath)
            val ch_Runnynose = view.findViewById<CheckBox>(R.id.Runnynose)
            val ch_Cough = view.findViewById<CheckBox>(R.id.Cough)

            if (ch_Sorethroat != null && ch_ShortOfBreath !=null && ch_Cough !=null && ch_Runnynose !=null && ch_Fever !=null) {
                if(ch_Sorethroat.isChecked && ch_ShortOfBreath.isChecked && ch_Cough.isChecked && ch_Runnynose.isChecked && ch_Fever.isChecked) {
                    val msg =
                        "\n \n You might have been INFECTED  with Corona Virus. Please consult doctor IMMEDIATELY."
                    comm.passData(msg)
                }
                else {
                    val msg = "\n \n You seem NOT INFECTED with Corona Virus."
                    comm.passData(msg)
                }
            }   //End NUll Check
        }   //End Submit listener
    }   //End onViewCreated
}   //end of InfectCheckFragment Class
