package com.example.testjob

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MyApp : Application() {
    // Hilt will generate the necessary components and inject dependencies here.
}