package com.example.data.repository

import android.content.Context
import com.example.domain.models.DataHome
import com.example.domain.models.DataSearchResponse
import com.example.domain.repository.RepositoryHome
import com.example.domain.repository.RepositorySearch
import com.google.gson.Gson
import dagger.hilt.android.qualifiers.ApplicationContext
import java.io.InputStreamReader
import javax.inject.Inject

class SearchRepositoryImpl @Inject constructor(
    @ApplicationContext private val context: Context
) : RepositorySearch {
    override fun getSearchData(): DataSearchResponse {
        val inputStream = context.assets.open("search_response.json")
        val reader = InputStreamReader(inputStream)
        return Gson().fromJson(reader, DataSearchResponse::class.java)
    }
}
