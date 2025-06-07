package com.example.moodlog.view

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.compose.rememberNavController
import com.example.moodlog.components.ButtonSave
import com.example.moodlog.components.EmojiGrid
import com.example.moodlog.components.TextBox
import com.example.moodlog.domain.MoodType
import com.example.moodlog.repository.MoodRepository
import com.example.moodlog.ui.theme.Blue_My
import com.example.moodlog.ui.theme.White_My
import com.example.moodlog.ui.theme.Yellow_My
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MoodScreen(
    navController: NavController

) {
    val scope = rememberCoroutineScope()
    val context = LocalContext.current
    val moodRepository = MoodRepository()
    var selectedEmoji by remember { mutableStateOf<MoodType?>(null) }
    var onEmojiSelect: (MoodType) -> Unit
    var descriptionBox by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(White_My)
    )
    {
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
            emojis = listOf(
                MoodType.HAPPY,
                MoodType.IN_LOVE,
                MoodType.ANGRY,
                MoodType.CONFUSED,
                MoodType.SAD,
                MoodType.NEUTRAL,
                MoodType.EXCITED,
                MoodType.TIRED
            ),
            selectedEmoji = selectedEmoji,
            onEmojiSelect = { emoji ->
                selectedEmoji = emoji
            },
            modifier = Modifier
        )
        TextBox(
            value = descriptionBox,
            onValueChange = { if (it.length <= 300) descriptionBox = it },
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .padding(16.dp, 0.dp, 16.dp, 2.dp),
            label = "Quer escrever algo sobre seu dia?",
            maxLines = 5,
            keyboardType = KeyboardType.Text,
        )
        Text(
            text = "${descriptionBox.length}/300",
            fontSize = 16.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp, 0.dp, 16.dp, 0.dp),
        )

        ButtonSave(
            onClick = {
                var message = false
                scope.launch(Dispatchers.IO) {
                    if (selectedEmoji != null && descriptionBox.isNotEmpty()) {
                        message = true
                        moodRepository.saveMood(selectedEmoji!!.symbol, descriptionBox)
                    }
                }
                scope.launch(Dispatchers.Main) {
                    if (message) {
                        Toast.makeText(context, "Salvo com sucesso!", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(
                            context,
                            "Todos os campos devem ser preenchidos",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            },
            modifier = Modifier
                .width(262.dp)
                .height(50.dp)
                .padding(16.dp, 0.dp, 16.dp, 0.dp)
                .offset(y = 40.dp)
                .align(Alignment.CenterHorizontally),
            text = "Salvar"
        )
    }
}

@Composable
@Preview
fun MoodScreenView() {
    val navController = rememberNavController()
    MoodScreen(navController = navController)
}