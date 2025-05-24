package com.example.moodlog.view

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.compose.rememberNavController
import com.example.moodlog.components.EmojiGrid
import com.example.moodlog.components.TextBox
import com.example.moodlog.ui.theme.Blue_My
import com.example.moodlog.ui.theme.White_My
import com.example.moodlog.ui.theme.Yellow_My
import java.nio.file.WatchEvent

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MoodScreen(
    navController: NavController
) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .background(White_My)

        ) {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                textAlign = TextAlign.Center,
                text = "MoodLog",
                color = Yellow_My,
                fontSize = 50.sp,
            )
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                textAlign = TextAlign.Center,
                text = "Como você está se sentindo hoje?",
                color = Blue_My,
                fontSize = 23.sp,
            )
            EmojiGrid(
                modifier = Modifier.fillMaxWidth(),
                columns = GridCells.Fixed(4),
                contentPadding = PaddingValues(horizontal = 16.dp),


            )
//            TextBox(
//                value = TODO(),
//                onValueChange = TODO(),
//                modifier = Modifier.fillMaxWidth(),
//                label = TODO(),
//                maxLines = TODO(),
//                keyboardType = TODO()
//            )
        }
    }
@Composable
@Preview
fun MoodScreenView(){
    val navController = rememberNavController()
    MoodScreen(navController =navController)
}