package com.st10454832.myweatherapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.st10454832.myweatherapp.R.id.startButton

class Splash : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_splash)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
import android.content.Intent


import android.widget.Button

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_splash)

        val startButton = findViewById<Button>(R.id.startButton)

        val exitButton = findViewById<Button>(R.id.exitButton)

        startButton.setOnClickListener {

            val intent = Intent(this, MainActivity::class.java)

            startActivity(intent)

        }

        exitButton.setOnClickListener {

            finish()

        }

    }