package com.example.bmi_cal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val heightEditText = findViewById<EditText>(R.id.et_height)
        val weightEditText = findViewById<EditText>(R.id.et_weight)
        val submitButton = findViewById<Button>(R.id.btn_check)

        
        submitButton.setOnClickListener {
            if(heightEditText.text.isEmpty()){
                Toast.makeText(this, "신장을 입려해 주세요.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if(weightEditText.text.isEmpty()){
                Toast.makeText(this, "체중을 입려해 주세요.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val height = heightEditText.text.toString().toInt()
            val weight = weightEditText.text.toString().toInt()

            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("height", height)
            intent.putExtra("weight", weight)
            startActivity(intent)
        }
    }
}