package com.example.moodlog.view


import android.app.AlertDialog
import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.moodlog.R
import com.example.moodlog.model.MoodModel
import com.example.moodlog.repository.MoodRepository
import com.example.moodlog.ui.theme.Blue_My
import com.example.moodlog.ui.theme.Gray_My
import com.example.moodlog.ui.theme.ShapeMoodCard
import com.example.moodlog.ui.theme.Yellow_My
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


@Composable
fun MoodCard(
    position: Int,
    listMood: MutableList<MoodModel>,
    context: Context,
    navController: NavController
) {
    val mood = listMood[position].mood
    val description = listMood[position].description
    val scope = rememberCoroutineScope()
    val moodRepository = MoodRepository()

    fun dialogDeleteMood() {
        val alertDialog = AlertDialog.Builder(context)
        alertDialog
            .setTitle("Deletar Mood")
            .setMessage("Tem certeza que deseja deletar este mood?")
            .setPositiveButton("Sim") { _, _ ->
                moodRepository.deleteMood(mood.toString())
                scope.launch(Dispatchers.Main) {
                    listMood.removeAt(position)
                    navController.navigate("mood_history")
                    Toast.makeText(context, "Mood deletado com sucesso!", Toast.LENGTH_SHORT).show()
                }
            }
            .setNegativeButton("Não") { _, _ -> }
            .show()
    }

    Card(
        colors = CardDefaults.cardColors(containerColor = Gray_My),
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        shape = ShapeMoodCard.small,
        border = BorderStroke(
            width = 1.dp,
            color = Yellow_My
        ),
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = description ?: "Sem descrição",
                    color = Blue_My,
                    fontSize = 16.sp,
                    modifier = Modifier.weight(1f)
                )

                var pressed by remember { mutableStateOf(false) }
                IconButton(
                    onClick = {
                        dialogDeleteMood()
                        pressed = true
                    },
                    modifier = Modifier.then(
                        if (pressed) Modifier.padding(2.dp) else Modifier
                    ),
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.icon_delete),
                        modifier = Modifier
                            .size(100.dp)
                            .padding(bottom = 10.dp),
                        tint = if (pressed) Yellow_My else Blue_My,
                        contentDescription = "Deletar Mood"
                    )
                }
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = mood ?: "Sem humor",
                    fontSize = 35.sp,
                )
            }
        }
    }
}