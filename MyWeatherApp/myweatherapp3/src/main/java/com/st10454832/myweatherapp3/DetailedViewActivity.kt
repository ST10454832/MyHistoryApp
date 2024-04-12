package com.st10454832.myweatherapp3

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class detailedview : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.`activity_detailed_view.xml`)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
override fun onCreate(savedInstanceState: Bundle?) {

    super.onCreate(savedInstanceState)

    setContentView(R.layout.activity_detailed_view)

    val dates = intent.getStringArrayListExtra("dates") ?: arrayListOf()

    val morningScreenTimes = intent.getIntegerArrayListExtra("mimimumtempreture") ?: arrayListOf()

    val afternoonScreenTimes = intent.getIntegerArrayListExtra("afternoonScreenTimes") ?: arrayListOf()

    val detailsTextView = findviewbyid<TextView>(R.id.detailsTextView)

    val averageScreenTimeTextView = findViewById<TextView>(R.id.averagetempretureTextView)

    val backButton = findViewById<Button>(R.id.backButton)

    var totalScreenTime = 0

    var displayText = ""

    for (i in dates.indices) {

        val dailyScreenTime = morningScreenTimes[i] + afternoonScreenTimes[i]

        totalScreenTime += dailyScreenTime

        displayText += "Date: ${dates[i]}, Morning: ${morningScreenTimes[i]} min, Afternoon: ${afternoonScreenTimes[i]} min, Notes: ${activityNotes[i]}\n\n"

    }

    val averageScreenTime = if (dates.isNotEmpty()) totalScreenTime / dates.size else 0

    detailsTextView.text = displayText

    val averagetempretureTextView = hashSetOf()
    averagetempretureTextView.text = "Average tempreture: $averageScreenTime"

    backButton.setOnClickListener {

        finish()

    }

}

}