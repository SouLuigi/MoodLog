package com.example.moodlog.view

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.moodlog.model.MoodModel
import com.example.moodlog.ui.theme.White_My
import com.example.moodlog.ui.theme.Yellow_My


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MoodHistory(
    navController: NavController
) {
    Scaffold(
        topBar = {
            TopAppBar(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp, 2.dp, 16.dp, 10.dp),
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Transparent,
                ),
                title = {
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center,
                        text = "Histórico",
                        fontSize = 50.sp,
                        color = Yellow_My
                    )
                }
            )
        },
        containerColor = White_My,
    )
    { innerPadding ->
        val listMood: MutableList<MoodModel> = mutableListOf(
            MoodModel(
                mood = "😊",
                description = "Hoje o céu está limpo, o sol brilha forte, e tudo parece calmo, leve e cheio de esperança.",
            ),
            MoodModel(
                mood = "😒",
                description = "Acordar cedo nem sempre é fácil, mas cada novo dia traz uma chance diferente de fazer melhor. Com paciência, foco e vontade, até os maiores sonhos podem sair do papel. A vida é feita de escolhas simples que, com o tempo, constroem grandes mudanças. Nunca pare de tentar e acreditar.",
            ),
            MoodModel(
                mood = "😍",
                description = "parabéns!",
            ),
            MoodModel(
                mood = "😘",
                description = "Hoje o céu está limpo, o sol brilha forte, e tudo parece calmo, leve e cheio de esperança.",
            ),
            MoodModel(
                mood = "😘",
                description = "Você está muito bem hoje, parabéns!",
            ),
            MoodModel(
                mood = "😘",
                description = "Você está muito bem hoje, parabéns!",
            ),
            MoodModel(
                mood = "😘",
                description = "Hoje o céu está limpo, o sol brilha forte, e tudo parece calmo, leve e cheio de esperança.",
            ),
            MoodModel(
                mood = "😘",
                description = "Você está muito bem hoje, parabéns!",
            ),
            MoodModel(
                mood = "😘",
                description = "Hoje o céu está limpo, o sol brilha forte, e tudo parece calmo, leve e cheio de esperança.",
            ),
            MoodModel(
                mood = "😘",
                description = "Hoje o céu está limpo, o sol brilha forte, e tudo parece calmo, leve e cheio de esperança.",
            ),
        )
        LazyColumn(
            contentPadding = innerPadding,
            modifier = Modifier.fillMaxSize()
        ){
            itemsIndexed(listMood) {
                position, mood -> MoodCard(position, listMood)
        }
        }
    }
}

@Composable
@Preview
fun MoodHistoryPreview() {
    val navController = rememberNavController()
    MoodHistory(navController = navController)
}