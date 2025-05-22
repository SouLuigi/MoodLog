package com.example.moodlog

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.moodlog.navigation.AppNavigation
import com.example.moodlog.ui.theme.MoodLogTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MoodLogTheme {
                AppNavigation()
            }
        }
    }
}
