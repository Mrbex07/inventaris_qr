package com.example.myapplication.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import com.example.myapplication.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var btn1 = findViewById<LinearLayout>(R.id.btn1)
        var btn2 = findViewById<LinearLayout>(R.id.btn2)

        btn1.setOnClickListener() {
            intent = Intent(this, scan::class.java)
            startActivity(intent)
        }
        btn2.setOnClickListener() {
            intent = Intent(this,table::class.java)
            startActivity(intent)
        }
    }
}