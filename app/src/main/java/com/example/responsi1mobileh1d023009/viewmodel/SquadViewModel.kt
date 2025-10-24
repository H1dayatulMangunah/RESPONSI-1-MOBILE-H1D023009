package com.example.responsi1mobileh1d023009.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.responsi1mobileh1d023009.data.model.TeamResponse
import com.example.responsi1mobileh1d023009.data.network.RetrofitInstance
import com.example.responsi1mobileh1d023009.utils.Constants
import kotlinx.coroutines.launch

class SquadViewModel : ViewModel() {

    private val _team = MutableLiveData<TeamResponse?>()
    val team: LiveData<TeamResponse?> get() = _team

    fun fetchTeam() {
        viewModelScope.launch {
            try {
                val response = RetrofitInstance.api.getTeam(
                    Constants.TEAM_ID,
                    Constants.API_TOKEN
                )
                if (response.isSuccessful) {
                    _team.postValue(response.body())
                } else {
                    _team.postValue(null)
                }
            } catch (e: Exception) {
                e.printStackTrace() // 🔹 tambahkan log error agar lebih mudah debug
                _team.postValue(null)
            }
        }
    }
}
