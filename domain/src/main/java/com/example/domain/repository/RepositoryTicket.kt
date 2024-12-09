package com.example.domain.repository

import com.example.domain.models.DataHome
import com.example.domain.models.DataSearchResponse
import com.example.domain.models.DataTicketResponse

interface RepositoryTicket {
    fun getTicketData(): DataTicketResponse
}
