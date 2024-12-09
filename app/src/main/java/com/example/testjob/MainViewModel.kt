package com.example.testjob

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.models.DataHome
import com.example.domain.models.DataSearchResponse
import com.example.domain.models.DataTicketResponse
import com.example.domain.repository.RepositoryHome
import com.example.domain.repository.RepositorySearch
import com.example.domain.repository.RepositoryTicket
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val homeRepository: RepositoryHome, private val searchRepository: RepositorySearch, private val ticketsRepository: RepositoryTicket
) : ViewModel() {

    private val _homeData = MutableStateFlow<DataHome?>(null)
    val homeData: StateFlow<DataHome?> = _homeData

    private val _searchResponse = MutableStateFlow<DataSearchResponse?>(null)
    val searchResponse: StateFlow<DataSearchResponse?> = _searchResponse

    fun fetchHomeData() {
        viewModelScope.launch {
            val data = homeRepository.getHomeData()
            _homeData.value = data
        }
    }

    fun fetchSearchData() {
        viewModelScope.launch {
            val data = searchRepository.getSearchData()
            _searchResponse.value = data
        }
    }

    var ticketResponse: DataTicketResponse? = null

    fun fetchTicketData() {
        viewModelScope.launch {
            ticketResponse = ticketsRepository.getTicketData()
        }
    }
}
