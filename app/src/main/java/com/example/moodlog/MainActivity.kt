package com.example.moodlog

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.moodlog.navigation.AppNavigation
import com.example.moodlog.ui.theme.MoodLogTheme
import com.example.moodlog.view.MoodHistory
import com.example.moodlog.view.MoodScreen

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
