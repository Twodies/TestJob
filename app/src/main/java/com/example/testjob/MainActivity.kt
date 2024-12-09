package com.example.testjob

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val mainViewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        getData()


    }

    private fun getData() {
        mainViewModel.fetchHomeData()

        lifecycleScope.launch {
            mainViewModel.homeData.collect { homeData ->
                homeData?.let {
                    val offersText = it.offers.joinToString("\n") { offer ->
                        "${offer.title} - ${offer.town} - ${offer.price.value}"
                    }
                    Log.e("GETTING_DATA", "getData: " + offersText)
                }
            }
        }
    }
}