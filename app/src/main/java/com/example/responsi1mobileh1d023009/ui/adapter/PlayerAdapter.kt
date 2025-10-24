package com.example.responsi1mobileh1d023009.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.responsi1mobileh1d023009.R
import com.example.responsi1mobileh1d023009.data.model.Player
import com.example.responsi1mobileh1d023009.databinding.ListPemainBinding
import com.example.responsi1mobileh1d023009.ui.fragment.SquadFragment
import com.example.responsi1mobileh1d023009.viewmodel.SquadViewModel
import kotlin.properties.ReadOnlyProperty

class PlayerAdapter(
    private var players: List<Player>,
    private val listener: OnPlayerClickListener
) : RecyclerView.Adapter<PlayerAdapter.PlayerViewHolder>() {

    inner class PlayerViewHolder(val binding: ListPemainBinding)
        : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayerViewHolder {
        val binding = ListPemainBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PlayerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PlayerViewHolder, position: Int) {
        val player = players[position]
        holder.binding.tvName.text = player.name
        holder.binding.tvPosition.text = player.position ?: "-"
        holder.binding.tvNationality.text = player.nationality

        // Warna background sesuai posisi (gunakan safe call)
        val colorRes = when (player.position?.lowercase()) {
            "goalkeeper" -> R.color.kuning
            "defender" -> R.color.biru
            "midfielder" -> R.color.hijau
            "forward" -> R.color.merah
            else -> R.color.white
        }

        holder.binding.root.setBackgroundColor(
            ContextCompat.getColor(holder.itemView.context, colorRes)
        )

        // Football-Data API tidak punya gambar pemain, jadi pakai placeholder default
        Glide.with(holder.itemView)
            .load(R.drawable.player_placeholder)
            .into(holder.binding.imgPlayer)

        holder.binding.root.setOnClickListener { listener.onPlayerClick(player) }
    }

    override fun getItemCount(): Int = players.size

    fun setData(newPlayers: List<Player>) {
        players = newPlayers
        notifyDataSetChanged()
    }
}

interface OnPlayerClickListener {
    fun onPlayerClick(player: Player)
    fun viewModels(): ReadOnlyProperty<SquadFragment, SquadViewModel>
}
