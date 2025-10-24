package com.example.responsi1mobileh1d023009.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.example.responsi1mobileh1d023009.R
import com.example.responsi1mobileh1d023009.data.model.Player
import com.example.responsi1mobileh1d023009.databinding.FragmentPlayerDetailBinding

class PlayerDetailFragment(private val player: Player) : BottomSheetDialogFragment() {
    private var _binding: FragmentPlayerDetailBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPlayerDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.tvName.text = player.name
        binding.tvPosition.text = player.position ?: "-"
        binding.tvNationality.text = player.nationality

        // karena API tidak menyediakan imageUrl, gunakan placeholder
        Glide.with(this)
            .load(R.drawable.player_placeholder)
            .into(binding.imgPlayer)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
