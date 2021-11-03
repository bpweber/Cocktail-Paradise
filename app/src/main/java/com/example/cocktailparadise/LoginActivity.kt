package com.example.cocktailparadise

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.firestore.FirebaseFirestore

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        findViewById<Button>(R.id.bLogin2).setOnClickListener {
            val email = findViewById<EditText>(R.id.textEmail2).text.toString()
            val password = findViewById<EditText>(R.id.textPassword2).text.toString()


            val db = FirebaseFirestore.getInstance()
            val user: MutableMap<String, Any> = HashMap()

            user["email"] = email
            user["password"] = password

            db.collection("users")
                .get()
                .addOnCompleteListener{
                    val result: StringBuffer = StringBuffer()
                    if(it.isSuccessful){
                        for(document in it.result!!){
                            //Log.d("dbfirebase", "retrieve: ${document.data.getValue("email")} "+
                            //        "${document.data.getValue("password")}")
                            if((document.data.getValue("email") == email) && (document.data.getValue("password") == password)){
                                intent = Intent(this, HomeActivity::class.java)
                                startActivity(intent)
                            }else{
                                Toast.makeText(this, "Either your id or password is incorrect", Toast.LENGTH_LONG).show()
                            }
                        }
                    }
                }
        }
    }
}