package com.example.ageinminutesapp

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.time.Month
import java.time.MonthDay
import java.time.Year
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // ukazywanie kalendarza by wybrać datę.
        selectDateButton.setOnClickListener { view -> dataPicker(view) }

    }

    //funkcja pokazująca kalendarz i dająca możliwość wybrania daty
    fun dataPicker(view: View){
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        DatePickerDialog(this,
                DatePickerDialog.OnDateSetListener { view, year, month, day ->

                    val selectedDate = "$day/${month+1}/$year"

                    selectedDateText.setText(selectedDate)

                    val simpleDateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)

                    val date = simpleDateFormat.parse(selectedDate)
                   //!! bo date może być null więc wymuszamy
                    val dateInMinutes = date!!.time / 60000

                    val currDate = simpleDateFormat.parse(simpleDateFormat.format(System.currentTimeMillis()))
                    val currDateInMinutes = currDate!!.time / 60000

                    ageInMinuteText.setText("${currDateInMinutes-dateInMinutes}")
                }
        , year, month, day).show()
    }

    fun calculateAge(day: MonthDay, month: Month, year: Year ){

    }

}


