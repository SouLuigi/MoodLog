package com.example.moodlog.view

import android.annotation.SuppressLint
import android.widget.Toast
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.moodlog.model.MoodModel
import com.example.moodlog.ui.theme.White_My
import com.example.moodlog.ui.theme.Yellow_My
import com.google.firebase.firestore.FirebaseFirestore


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
        @Composable
        fun MoodListHistory() {
            val listMood = remember { mutableStateOf<List<MoodModel>>(emptyList()) }
            val context = LocalContext.current

            LaunchedEffect(Unit) {
                FirebaseFirestore
                    .getInstance()
                    .collection("Moods")
                    .get()
                    .addOnSuccessListener { result ->
                        val lista =
                            result.documents.mapNotNull { it.toObject(MoodModel::class.java) }
                        listMood.value = lista
                    }
                    .addOnFailureListener {
                        Toast.makeText(context, "Erro ao carregar dados", Toast.LENGTH_SHORT).show()
                    }
            }
            LazyColumn(
                contentPadding = innerPadding,
                modifier = Modifier.fillMaxSize()
            ) {
                items(listMood.value) { mood ->
                    MoodCard(moodModel = mood, onDeleteClick = {

                    })
                }
            }
        }
    }
}