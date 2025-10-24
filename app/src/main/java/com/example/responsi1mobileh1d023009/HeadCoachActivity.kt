package com.example.responsi1mobileh1d023009

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.responsi1mobileh1d023009.databinding.ActivityHeadcoachBinding
import com.example.responsi1mobileh1d023009.viewmodel.SquadViewModel
import com.google.android.material.button.MaterialButton

class HeadCoachActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHeadcoachBinding
    private val viewModel: SquadViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHeadcoachBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.coachScroll) { v, insets ->
            val sysBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(sysBars.left, sysBars.top, sysBars.right, sysBars.bottom)
            insets
        }

        viewModel.fetchTeam()

        viewModel.team.observe(this) { team ->
            team?.coach?.let { coach ->
                binding.tvCoachName.text = coach.name ?: "Unknown"
                binding.tvTanggal.text = coach.dateOfBirth ?: "-"
                binding.tvTempat.text = coach.nationality ?: "-"
            }
        }

        findViewById<MaterialButton>(R.id.btn_back_coach).setOnClickListener {
            finish()
        }
    }
}
