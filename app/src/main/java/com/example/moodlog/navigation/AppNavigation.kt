package com.example.moodlog.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.CheckboxDefaults.colors
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.moodlog.ui.theme.Yellow_My
import com.example.moodlog.view.MoodHistory
import com.example.moodlog.view.MoodScreen
import com.example.moodlog.view.MoodStatistic

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    val currentBackStackEntry = navController.currentBackStackEntryAsState()
    val currentRoute = currentBackStackEntry.value?.destination?.route

    Scaffold(
        bottomBar = {
            BottomAppBar(
               containerColor = Yellow_My
            ) {
                IconButton(
                    onClick = { navController.navigate(Routes.MOOD_SCREEN) },
                    enabled = currentRoute != Routes.MOOD_SCREEN
                ) {
                    Icon(
                        imageVector = Icons.Default.Home,
                        contentDescription = "Tela de humor"
                    )
                }
                IconButton(
                    onClick = { navController.navigate(Routes.MOOD_HISTORY) },
                    enabled = currentRoute != Routes.MOOD_HISTORY
                ) {
                    Icon(
                        imageVector = Icons.Default.List,
                        contentDescription = "Histórico de humor"
                    )
                }
                IconButton(
                    onClick = { navController.navigate(Routes.MOOD_STATISTIC) },
                    enabled = currentRoute != Routes.MOOD_STATISTIC
                ) {
                    Icon(
                        imageVector = Icons.Default.AccountCircle,
                        contentDescription = "Estatística de humor"
                    )
                }
            }
        },
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Routes.MOOD_SCREEN,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(
                Routes.MOOD_SCREEN
            ) {
                MoodScreen(navController)
            }
            composable(
                Routes.MOOD_HISTORY
            ) {
                MoodHistory(navController)
            }
            composable(
                Routes.MOOD_STATISTIC
            ) { MoodStatistic(navController) }
        }
    }
}
