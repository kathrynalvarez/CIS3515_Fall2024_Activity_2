package edu.temple.inclassuiacvitivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.widget.*
import com.google.android.material.navigation.NavigationBarView.OnItemSelectedListener

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val spinner = findViewById<Spinner>(R.id.spinner)
        val displayTextView = findViewById<TextView>(R.id.textDisplay)

        /* TODO Step 2: Populate this array with multiples of 5 from 5 - 100*/
        //val numberArray = Array Of Numbers

        // val numberArray = Array(20, {(it + 1) * 5})
        val numberArray = Array(20) { i -> (i + 1) * 5 }
        Log.d("TAG", numberArray.joinToString(", "))

        /* TODO Step 3: Create adapter to display items from array in Spinner */
        spinner.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, numberArray)


        // TODO Step 4: Change TextView's text size to the number selected in the Spinner */
        spinner.onItemSelectedListener = object: OnItemSelectedListener, AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                p0?.run{
                    val numSize = getItemAtPosition(p2).toString()

                    displayTextView.textSize = numSize.toFloat()
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {}
            override fun onNavigationItemSelected(item: MenuItem): Boolean {
                TODO("Not yet implemented")
            }
        }

    }
}