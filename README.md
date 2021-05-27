# Project Name
> AgeInMinuteApp

## Table of contents
* [General info](#general-info)
* [Screenshots](#screenshots)
* [Technologies](#technologies)
* [Setup](#setup)
* [Features](#features)
* [Status](#status)
* [Inspiration](#inspiration)


## General info
Simple counting age in minutes application. Created to learn the fundamentals of Kotlin and Android Studio.

## Screenshots
Example screenshot with app view after picking date.

<img src=./img/screenshot.png width="400" >

## Technologies
* Android Studio - version 4.1.2
* Kotlin - version 1.3.72
* Minimum SDK - version API 16: Android 4.1(Jelly Bean)
* Android Virtual Devide - Pixel 4 API 25

## Setup
To run application and check it out you will need Android Studio environment. If you have already installed Android Studio environment,
the next step is to create Android Virtual Device in Android Virtual Device Manager. 
If environment is ready, then open the project in Android Studio and click "Run 'app'". 

## Code Examples
Main function responsible for data picking and transfering age to minutes:
```Kotlin
fun dataPicker(){
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
                   //!! date can be 'null' so we have to use 'force' : '!!'
                    val dateInMinutes = date!!.time / 60000

                    val currDate = simpleDateFormat.parse(simpleDateFormat.format(System.currentTimeMillis()))
                    val currDateInMinutes = currDate!!.time / 60000

                    ageInMinuteText.setText("${currDateInMinutes-dateInMinutes}")
                }
        , year, month, day).show()
    }
```

## Features
List of features ready and TODOs for future development
* Picking date and calculating age to minutes function
* Transparent UI

To-do list:
* Change the main function to be real-time counting function
* Add options to calculate age additionally to hours, weeks, ect. 
Not only to minutes.

## Status
Project is: _in progress_

## Inspiration
My inspiration to create such an app was a willings to learn how to use Android Studio environment and Koltin language.
It was my first steps so I appreciate your understanding in the matter. 
