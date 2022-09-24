package com.reiscompaim.myapplication

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    var date_txt: TextView?=null
    var result_txt: TextView?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        date_txt=findViewById(R.id.date_txt)
        result_txt=findViewById(R.id.result_txt)
        val date_btn : Button = findViewById(R.id.date_btn)
        date_btn.setOnClickListener{
            //Toast.makeText(this, "Clicked",Toast.LENGTH_LONG).show()
            clickDatePicker();
        }

    }

    fun clickDatePicker(){
        val myCalendar= Calendar.getInstance()
        val year= myCalendar.get(Calendar.YEAR)
        val month= myCalendar.get(Calendar.MONTH)
        val day= myCalendar.get(Calendar.DAY_OF_MONTH)



        DatePickerDialog(this,
            DatePickerDialog.OnDateSetListener{view, year,month, dayOfMonth ->

                val selectedDate= "$dayOfMonth/${month + 1}/$year"
                date_txt?.setText(selectedDate)
                val sdf= SimpleDateFormat("dd/mm/yyyy", Locale.UK)
                val theDate= sdf.parse(selectedDate)
                val inMinutes= theDate.time/6000
                val currentDate= sdf.parse(sdf.format(System.currentTimeMillis()))
                val currentDateInMinutes= currentDate.time/6000
                val differenceInMinutes= currentDateInMinutes - inMinutes
                result_txt?.text= differenceInMinutes.toString()
            },
            year,month,day

            ).show()


    }
}