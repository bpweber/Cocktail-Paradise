package com.example.cocktailparadise

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val login = findViewById<Button>(R.id.bLogin)
        login.setOnClickListener{
            intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
        val signup = findViewById<Button>(R.id.bSignup)
        signup.setOnClickListener{
            intent = Intent(this, SignupActivity::class.java)
            startActivity(intent)
        }
    }
}