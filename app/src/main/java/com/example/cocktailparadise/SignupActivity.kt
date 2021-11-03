package com.example.cocktailparadise

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.firestore.FirebaseFirestore

class SignupActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        findViewById<Button>(R.id.bSignup1).setOnClickListener {
            val email = findViewById<EditText>(R.id.textEmail1).text.toString()
            val password = findViewById<EditText>(R.id.textPassword1).text.toString()
            val confirmPassword = findViewById<EditText>(R.id.textConfirmPassword1).text.toString()
            val firstName = findViewById<EditText>(R.id.textFirstName1).text.toString()
            val lastName = findViewById<EditText>(R.id.textLastName1).text.toString()

            if (password != confirmPassword) {
                Toast.makeText(this, "Passwords do not match!", Toast.LENGTH_LONG).show()
            } else {

                val db = FirebaseFirestore.getInstance()
                val user: MutableMap<String, Any> = HashMap()

                user["email"] = email
                user["password"] = password
                user["firstName"] = firstName
                user["lastName"] = lastName

                db.collection("users")
                    .add(user)
                    .addOnSuccessListener {
                        Log.d("dbfirebase", "save: ${user}")
                    }
                    .addOnFailureListener {
                        Log.d("dbfirebase Failed", "${user}")
                    }
                Toast.makeText(this, "You successfully created account!", Toast.LENGTH_LONG).show()
            }
        }
    }
}