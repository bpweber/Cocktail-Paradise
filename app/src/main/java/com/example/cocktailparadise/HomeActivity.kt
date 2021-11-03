package com.example.cocktailparadise

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val popular = findViewById<Button>(R.id.bPopular)
        popular.setOnClickListener{
            intent = Intent(this, PopularActivity::class.java)
            startActivity(intent)
        }
        val search = findViewById<Button>(R.id.bSearch)
        search.setOnClickListener{
            intent = Intent(this, SearchActivity::class.java)
            startActivity(intent)
        }
    }
}