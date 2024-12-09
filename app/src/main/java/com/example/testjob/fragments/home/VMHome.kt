package com.example.testjob.fragments.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.models.DataHome
import com.example.domain.repository.RepositoryHome
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class VMHome @Inject constructor(
    private val homeRepository: RepositoryHome
) : ViewModel() {

    private val _homeData = MutableStateFlow<DataHome?>(null)
    val homeData: StateFlow<DataHome?> = _homeData

    init {
        fetchHomeData()
    }

    private fun fetchHomeData() {
        viewModelScope.launch {
            val data = homeRepository.getHomeData()
            _homeData.value = data
        }
    }

}