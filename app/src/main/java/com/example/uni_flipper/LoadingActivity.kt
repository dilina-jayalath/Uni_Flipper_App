package com.example.uni_flipper

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity

class LoadingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.loading_page)

        // Delay for 3 seconds (3000 milliseconds)
        Handler().postDelayed({
            // Create an Intent to navigate to the LoginActivity
            val intent = Intent(this@LoadingActivity, MainActivity::class.java)
            startActivity(intent)
            finish() // Finish the current activity to prevent going back to it
        }, 500)
    }
}
