package com.example.moodlog.view

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.moodlog.components.TextBox
import com.example.moodlog.ui.theme.Blue_My
import com.example.moodlog.ui.theme.White_My
import com.example.moodlog.ui.theme.Yellow_My

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MoodScreen(
    navController: NavController
) {
//    Scaffold(
//        containerColor = White_My,
//        topBar = {
//            CenterAlignedTopAppBar(
//                title = {
//                    Text(
//                        text = "MoodLog",
//                        fontSize = 45.sp,
//                        fontWeight = FontWeight.Bold,
//                        color = Yellow_My,
//                    )
//                },
//                colors = TopAppBarDefaults.topAppBarColors(
//                    containerColor = White_My
//                ),
//                modifier = Modifier
//                    .statusBarsPadding()
//            )
//        }
//    ){}

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .background(White_My)

        ) {
            Text(
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                text = "MoodLog",
                color = Yellow_My,
                fontSize = 50.sp,
            )
            Text(
                text = "Como você está se sentindo hoje?",
                color = Blue_My
            )
//            TextBox(
//                value = TODO(),
//                onValueChange = TODO(),
//                modifier = TODO(),
//                label = TODO(),
//                maxLines = TODO(),
//                keyboardType = TODO()
//            )
        }
    }
