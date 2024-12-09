package com.example.data.repository

import android.content.Context
import com.example.domain.models.DataSearchResponse
import com.example.domain.models.DataTicketResponse
import com.example.domain.repository.RepositorySearch
import com.example.domain.repository.RepositoryTicket
import com.google.gson.Gson
import dagger.hilt.android.qualifiers.ApplicationContext
import java.io.InputStreamReader
import javax.inject.Inject

class TicketRepositoryImpl @Inject constructor(
    @ApplicationContext private val context: Context
) : RepositoryTicket {
    override fun getTicketData(): DataTicketResponse {
        val inputStream = context.assets.open("all_tickets.json")
        val reader = InputStreamReader(inputStream)
        return Gson().fromJson(reader, DataTicketResponse::class.java)
    }
}

