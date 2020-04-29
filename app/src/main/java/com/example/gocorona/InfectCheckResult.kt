package com.example.gocorona

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

/*This fragment if for displaying result of InfectCheck*/
/*Created by Doulaghar*/

class InfectCheckResult : Fragment() {
    var resultString : String? = ""
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_infect_check_result, container, false)
    }   //End onCreate

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        resultString = arguments?.getString("resultIFCheck")
        view.findViewById<TextView>(R.id.resultTextView).text = "Based on your symptoms, here is the result. $resultString"
    }   //End onViewCreated
}   //End of class InfectCheckResult
