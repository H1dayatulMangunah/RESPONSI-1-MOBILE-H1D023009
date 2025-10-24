package com.example.responsi1mobileh1d023009

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.responsi1mobileh1d023009.databinding.ActivitySquadBinding
import com.example.responsi1mobileh1d023009.ui.fragment.SquadFragment


class SquadActivity : AppCompatActivity() {

    // Deklarasi View Binding, sudah benar.
    private lateinit var binding: ActivitySquadBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        // Panggil super.onCreate() di baris paling atas, ini adalah praktik terbaik.
        super.onCreate(savedInstanceState)

        // Inisialisasi View Binding.
        binding = ActivitySquadBinding.inflate(layoutInflater)
        // Gunakan root dari binding sebagai content view.
        setContentView(binding.root)

        // Terapkan Window Insets agar UI tidak tumpang tindih dengan System Bars (Status Bar, dll.)
        // Kita menggunakan `binding.root` sebagai target agar listener diterapkan ke seluruh layout activity.
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            // Atur padding pada View utama agar konten di dalamnya tidak terhalang.
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            // Kembalikan insets asli agar window dapat memprosesnya lebih lanjut.
            insets
        }

        // Muat fragment utama hanya jika activity baru dibuat (bukan saat rotasi layar, dll.)
        // Pengecekan `savedInstanceState == null` ini sangat penting dan sudah Anda lakukan dengan benar.
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                // Ganti konten dari `fragment_container` dengan instance `SquadFragment`.
                .replace(binding.fragmentContainer.id, SquadFragment())
                .commit()
        }
    }
}
