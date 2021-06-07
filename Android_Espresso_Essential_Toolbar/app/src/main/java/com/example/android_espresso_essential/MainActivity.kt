package com.example.android_espresso_essential

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var greetingButton: View
    private lateinit var greetingView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setTitle(R.string.title)
        greetingButton = findViewById(R.id.greet_button)
        greetingView = findViewById(R.id.greeting)
    }

    fun greet(v: View) {
        greetingButton.isEnabled = false
        greetingView.setText(R.string.hello)
    }
}