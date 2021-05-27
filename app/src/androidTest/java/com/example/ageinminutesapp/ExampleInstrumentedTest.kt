package com.example.ageinminutesapp

import android.util.Log

import android.widget.DatePicker
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.PickerActions

import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import kotlinx.android.synthetic.main.activity_main.*


import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import java.text.SimpleDateFormat

import java.util.*

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.example.ageinminutesapp", appContext.packageName)
    }
    // test to check
    
    // hand-made test
    @Test
    fun MainActivityTest(){

        val activityScenario: ActivityScenario<MainActivity> = ActivityScenario.launch(MainActivity::class.java)

        val cal = Calendar.getInstance()
        val y = cal.get(Calendar.YEAR)
        val m = cal.get(Calendar.MONTH)
        val d = cal.get(Calendar.DAY_OF_MONTH) - 1

        val selectedDate = "$d/${m+1}/$y"
        val simpleDateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)
        val date = simpleDateFormat.parse(selectedDate)

        val dateInMinutes = date!!.time / 60000
        val currDate = simpleDateFormat.parse(simpleDateFormat.format(System.currentTimeMillis()))
        val currDateInMinutes = currDate!!.time / 60000

        val testDate = "${currDateInMinutes-dateInMinutes}"

        // Show the date picker
        onView(withId(R.id.selectDateButton)).perform(click())
        // Sets a date on the date picker widget
        onView(isAssignableFrom(DatePicker::class.java)).perform(
           PickerActions.setDate(
                y,
                m+1,
                d
           )
        )
        // Confirm the selected date. This example uses a standard DatePickerDialog
        // which uses
        // android.R.id.button1 for the positive button id.
        onView(withId(android.R.id.button1)).perform(click())

        // / Check if the selected date is correct after calculating
        onView(withId(R.id.ageInMinuteText)).check(matches(withText(testDate)))
        // additional log for me
        Log.i("HI","hello $y ${m+1} $d")

    }
}


