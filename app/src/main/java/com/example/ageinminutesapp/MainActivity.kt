package com.example.ageinminutesapp

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // ukazywanie kalendarza by wybrać datę.
        selectDateButton.setOnClickListener { view -> dataPicker() }

    }


    //function showing the calendar and giving the possibility to choose date
    fun dataPicker() {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        DatePickerDialog(this,
                DatePickerDialog.OnDateSetListener {view, year, month, day ->

                    val selectedDate = "$day/${month+1}/$year"

                    selectedDateText.setText(selectedDate)

                    val simpleDateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)

                    val date = simpleDateFormat.parse(selectedDate)
                   //!! date can be 'null' so we have to use 'force' : '!!'
                    val dateInMinutes = date!!.time / 60000

                    val currDate = simpleDateFormat.parse(simpleDateFormat.format(System.currentTimeMillis()))
                    val currDateInMinutes = currDate!!.time / 60000

                    ageInMinuteText.setText("${currDateInMinutes-dateInMinutes}")
                }
        , year, month, day).show()
    }

}


