package com.st10454832.myweatherapp2

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
import android.content.Intent

import android.widget.Button

import android.widget.EditText

import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private val dates = ArrayList<String>()

    private val morningScreenTimes = ArrayList<Int>()

    private val afternoonScreenTimes = ArrayList<Int>()

    private val activityNotes = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val dayEditText = findViewById<EditText>(R.id.dayedittext)

        val mininumtempreture = findViewById<EditText>(R.id.minimumtemp)

        val miximumtempreture = findViewById<EditText>(R.id.miximumtemp)


        val addButton = findViewById<Button>(R.id.addButton)

        val clearButton = findViewById<Button>(R.id.clearButton)

        val viewDetailsButton = findViewById<Button>(R.id.viewDetailsButton)

        addButton.setOnClickListener {

            val date = dayEditText.text.toString()

            val morningScreenTime = mininumtempreture.text.toString().toIntOrNull()

            val afternoonScreenTime = miximumtempreture.text.toString().toIntOrNull()



            if (date.isNotEmpty() && morningScreenTime != null && afternoonScreenTime != null && . isNotEmpty) {

                dates.add(date)

                morningScreenTimes.add(morningScreenTime)

                afternoonScreenTimes.add(afternoonScreenTime)


                Toast.makeText(this, "Data Added", Toast.LENGTH_SHORT).show()

                clearFields(dayEditText, mininumtempreture, miximumtempreture)

            } else {

                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()

            }

        }

        clearButton.setOnClickListener {

            dates.clear()

            morningScreenTimes.clear()

            afternoonScreenTimes.clear()

            activityNotes.clear()

            Toast.makeText(this, "Data Cleared", Toast.LENGTH_SHORT).show()

        }

        viewDetailsButton.setOnClickListener {

            val intent = Intent(this, viewDetailsButton::class.java)

            intent.putStringArrayListExtra("dates", dates)

            intent.putIntegerArrayListExtra("morningScreenTimes", morningScreenTimes)

            intent.putIntegerArrayListExtra("afternoonScreenTimes", afternoonScreenTimes)

            intent.putStringArrayListExtra("activityNotes", activityNotes)

            startActivity(intent)

        }

    }

    private fun clearFields(vararg fields: EditText) {

        for (field in fields) {

            field.text.clear()

        }

    }
}