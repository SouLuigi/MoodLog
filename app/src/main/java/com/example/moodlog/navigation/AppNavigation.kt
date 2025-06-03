package com.example.moodlog.navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.moodlog.R
import com.example.moodlog.ui.theme.Blue_My
import com.example.moodlog.ui.theme.White_My
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
                modifier = Modifier.height(65.dp),
                containerColor = Yellow_My
            ) {
                Row(
                ) {
                    IconButton(
                        modifier = Modifier
                            .weight(1f)
                            .height(56.dp),
                        onClick = { navController.navigate(Routes.MOOD_SCREEN) },
                        enabled = currentRoute != Routes.MOOD_SCREEN
                    ) {
                        val isSelected = currentRoute == Routes.MOOD_SCREEN
                        val iconColor = if (isSelected) Blue_My else White_My
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Icon(
                                painter = painterResource(id = R.drawable.icon_house),
                                contentDescription = "Tela de Principal",
                                tint = iconColor
                            )
                            Text(
                                text = "Início",
                                fontSize = 12.sp,
                                modifier = Modifier.padding(top = 0.dp),
                                color = iconColor
                            )
                        }
                    }
                    IconButton(
                        modifier = Modifier
                            .weight(1f)
                            .height(56.dp),
                        onClick = { navController.navigate(Routes.MOOD_HISTORY) },
                        enabled = currentRoute != Routes.MOOD_HISTORY
                    ) {
                        val isSelected = currentRoute == Routes.MOOD_HISTORY
                        val iconColor = if (isSelected) Blue_My else White_My
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Icon(
                                painter = painterResource(id = R.drawable.icon_bookmark),
                                contentDescription = "Tela de histórico",
                                tint = iconColor
                            )
                            Text(
                                text = "Histórico",
                                fontSize = 12.sp,
                                modifier = Modifier.padding(top = 0.dp),
                                color = iconColor
                            )
                        }
                    }
                    IconButton(
                        modifier = Modifier
                            .weight(1f)
                            .height(56.dp),
                        onClick = { navController.navigate(Routes.MOOD_STATISTIC) },
                        enabled = currentRoute != Routes.MOOD_STATISTIC
                    ) {
                        val isSelected = currentRoute == Routes.MOOD_STATISTIC
                        val iconColor = if (isSelected) Blue_My else White_My
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Icon(
                                painter = painterResource(id = R.drawable.icon_chart),
                                contentDescription = "Estatística de humor",
                                tint = iconColor
                            )
                            Text(
                                text = "Estátistica",
                                fontSize = 12.sp,
                                modifier = Modifier.padding(top = 0.dp),
                                color = iconColor
                            )
                        }
                    }
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

