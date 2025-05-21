package com.example.moodlog.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.moodlog.view.MoodHistory
import com.example.moodlog.view.MoodScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Routes.MOOD_HISTORY
    ) {
        composable(
            Routes.MOOD_SCREEN
        ){
            MoodScreen(navController)
        }
        composable(
            Routes.MOOD_HISTORY
        ){
            MoodHistory(navController)
        }
    }
}