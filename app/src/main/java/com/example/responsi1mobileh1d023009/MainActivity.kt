package com.example.responsi1mobileh1d023009

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Tombol Next untuk kembali ke halaman awal
        val btnNext = findViewById<MaterialButton>(R.id.btn_to_page2)
        btnNext.setOnClickListener {
            val intent = Intent(this, Halaman2Activity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
