package com.example.domain.repository

import com.example.domain.models.DataHome

interface RepositoryHome {
    fun getHomeData(): DataHome
}
