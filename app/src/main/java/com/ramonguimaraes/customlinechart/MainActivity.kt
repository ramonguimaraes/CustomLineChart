package com.ramonguimaraes.customlinechart

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val customView = findViewById<CustomLineChart>(R.id.linearLayout)
        val addRed = findViewById<Button>(R.id.buttonAddRed)
        val addYellow = findViewById<Button>(R.id.buttonAddYellow)
        val addGreen = findViewById<Button>(R.id.buttonAddGreen)
        val addPurple = findViewById<Button>(R.id.buttonAddPurple)

        addRed.setOnClickListener {
            customView.addItem(Triple(10f, R.color.red, 0L))
        }

        addYellow.setOnClickListener {
            customView.addItem(Triple(10f, R.color.yellow, 1L))
        }

        addGreen.setOnClickListener {
            customView.addItem(Triple(10f, R.color.green, 2L))
        }

        addPurple.setOnClickListener {
            customView.addItem(Triple(10f, R.color.purple, 3L))
        }
    }
}