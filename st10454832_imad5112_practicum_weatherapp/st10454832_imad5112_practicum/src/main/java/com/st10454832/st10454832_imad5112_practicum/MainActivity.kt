package com.st10454832.st10454832_imad5112_practicum

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetailActivity

private fun plus() {

}

private operator fun Any.plus(maxTemp: Any): Any {

}

class MainActivity : AppCompatActivity() {
    class Weather {

        val minTemp: Any = TODO()
        val maxTemp: Any = TODO()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
            class MainActivity : AppCompatActivity() {
                private lateinit var weatherData: Array<Weather>

                @SuppressLint("MissingInflatedId")
                override fun onCreate(savedInstanceState: Bundle?) {
                    super.onCreate(savedInstanceState)
                    setContentView(R.layout.activity_main)

                    val btnCalculate = findViewById<Button>(R.id.calculateButton)
                    val btnDetails = findViewById<Button>(R.id.detailedViewButton)
                    val btnClear = findViewById<Button>(R.id.clearButton)

                    weatherData = arrayOf(
                        Weather(),
                        Weather(),
                        // Add other days
                    )

                    btnCalculate.setOnClickListener {
                        calculateAverageTemperature()
                    }

                    btnDetails.setOnClickListener {
                        val intent = Intent(this, DetailActivity::class.java)
                        intent.putExtra("weatherData", weatherData)
                        startActivity(intent)
                    }

                    btnClear.setOnClickListener {
                        clearData()
                    }
                }

                @SuppressLint("SetTextI18n")
                private fun calculateAverageTemperature() {
                    var totalTemp = 0
                    for (weather in weatherData) {
                        totalTemp += (weather.minTemp + weather.maxTemp) / 2
                    }
                    val averageTemp = totalTemp / weatherData.size
                    findViewById<TextView>(R.id.txtAverageTemp).text = "Average Temp: $averageTemp"
                }

                private fun clearData() {
                    // Logic to clear data
                }
            }