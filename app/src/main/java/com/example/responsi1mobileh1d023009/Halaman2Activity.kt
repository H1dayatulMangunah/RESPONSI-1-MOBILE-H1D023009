package com.example.responsi1mobileh1d023009

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton

class Halaman2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_halaman2)

        // Tombol back
        val btnBack = findViewById<MaterialButton>(R.id.btn_back)
        btnBack.setOnClickListener { finish() }

        // Menu includes
        val layoutHistory = findViewById<android.view.View>(R.id.layout_Club_History)
        val layoutCoach = findViewById<android.view.View>(R.id.layout_Head_Coach)
        val layoutSquad = findViewById<android.view.View>(R.id.layout_Team_Squad)

        // Atur label dan ikon
        layoutHistory.findViewById<TextView>(R.id.tv_layout).text = "Club History"
        layoutCoach.findViewById<TextView>(R.id.tv_layout).text = "Head Coach"
        layoutSquad.findViewById<TextView>(R.id.tv_layout).text = "Team Squad"

        layoutHistory.findViewById<ImageView>(R.id.img_icon).setImageResource(R.drawable.bola)
        layoutCoach.findViewById<ImageView>(R.id.img_icon).setImageResource(R.drawable.person)
        layoutSquad.findViewById<ImageView>(R.id.img_icon).setImageResource(R.drawable.team)

        // Klik listener
        layoutHistory.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        layoutCoach.setOnClickListener {
            val intent = Intent(this, HeadCoachActivity::class.java)
            startActivity(intent)
        }

        layoutSquad.setOnClickListener {
            val intent = Intent(this, SquadActivity::class.java)
            startActivity(intent)
        }
    }
}
