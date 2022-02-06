package com.example.tictactoe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        start_screen_logo.translationY = -1000f
        start_screen_text.translationY = 1000f
        start_screen_logo.animate().translationY(0f).duration = 2000
        start_screen_text.animate().translationY(0f).duration = 2000

        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, StartScreenActivity::class.java)
            startActivity(intent)
        }, 3000)
    }
}