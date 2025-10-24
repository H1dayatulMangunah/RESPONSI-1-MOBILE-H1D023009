package com.example.responsi1mobileh1d023009.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.responsi1mobileh1d023009.data.model.Player
import com.example.responsi1mobileh1d023009.databinding.FragmentSquadBinding
import com.example.responsi1mobileh1d023009.ui.adapter.OnPlayerClickListener
import com.example.responsi1mobileh1d023009.ui.adapter.PlayerAdapter
import com.example.responsi1mobileh1d023009.viewmodel.SquadViewModel
import kotlin.properties.ReadOnlyProperty

class SquadFragment : Fragment(), OnPlayerClickListener {

    private var _binding: FragmentSquadBinding? = null
    private val binding get() = _binding!!
    private val viewModel: SquadViewModel by viewModels()
    private val adapter = PlayerAdapter(emptyList(), this)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSquadBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Setup RecyclerView
        binding.recyclerViewSquad.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerViewSquad.adapter = adapter

        // Fetch data dari API lewat ViewModel
        viewModel.fetchTeam()

        // Observe hasil API
        viewModel.team.observe(viewLifecycleOwner) { team ->
            team?.squad?.let {
                adapter.setData(it)
            }
        }
    }

    override fun onPlayerClick(player: Player) {
        PlayerDetailFragment(player).show(parentFragmentManager, "PlayerDetail")
    }

    override fun viewModels(): ReadOnlyProperty<SquadFragment, SquadViewModel> {
        TODO("Not yet implemented")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
