package com.example.addingtwonumbers

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

/* My name is Harshdeep Bedi and my student number is N01358063. I wrote the code because it was part of my project lab,
I wrote this code on September 29 and this code should be checking which editView is empty and display the appropriate message in the toast, if they are filled
with their appropriate numbers then it adds them and there is also spinner used in this application that displays the hello message concatinated with the name of
the person selected from the spinner.
*/
private const val TAG = "MainActivity"
private const val KEY_RESULT = "result"
private var res = "result"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState != null) {
            res = savedInstanceState.getString(KEY_RESULT).toString()
        }
        // Log.i = (TAG, "OnCreate was called")

        if (editNum1.text.isEmpty()) {
            button.setOnClickListener {
                Toast.makeText(this, "Enter Num1", Toast.LENGTH_SHORT).show()
            }

            if (editNum2.text.isEmpty()) {
                button.setOnClickListener {
                    Toast.makeText(this, "Enter Num2", Toast.LENGTH_SHORT).show()
                }
            } else {
                button.setOnClickListener {
                    res =
                        (editNum1.text.toString().toInt() + editNum2.text.toString()
                            .toInt()).toString()
                    "Result:" + res
                    Toast.makeText(this, "Result " + textResult.text, Toast.LENGTH_LONG).show()

                }
            }
        }

        val personNames = arrayOf("Anna", "Alex", "Chris", "Richard", "Vlad", "Willy", "James")
        val arrayAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, personNames)
        // attached arrayAdapter to spinner
        spinner.adapter = arrayAdapter
        spinner.onItemSelectedListener = object :

            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                textName.text = " Hello " + personNames[p2]
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }
        }
    }

    override fun onPause() {
        super.onPause();
        Log.i(TAG, "OnPause() was called")
    }

    override fun onStop() {
        super.onStop();
        Log.i(TAG, "OnStop() was called")
    }

    override fun onResume() {
        super.onResume();
        Log.i(TAG, "OnResume() was called")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(KEY_RESULT, res)
    }
}
