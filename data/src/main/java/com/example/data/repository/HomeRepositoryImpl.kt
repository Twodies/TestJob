package com.example.data.repository

import android.content.Context
import com.example.domain.models.DataHome
import com.example.domain.repository.RepositoryHome
import com.google.gson.Gson
import dagger.hilt.android.qualifiers.ApplicationContext
import java.io.InputStreamReader
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(
    @ApplicationContext private val context: Context
) : RepositoryHome {
    override fun getHomeData(): DataHome {
        val inputStream = context.assets.open("home.json")
        val reader = InputStreamReader(inputStream)
        return Gson().fromJson(reader, DataHome::class.java)
    }
}