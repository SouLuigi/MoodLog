package com.example.moodlog.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.moodlog.R
import com.example.moodlog.model.MoodModel
import com.example.moodlog.ui.theme.Blue_My
import com.example.moodlog.ui.theme.Gray_My
import com.example.moodlog.ui.theme.Yellow_My


@Composable
fun MoodCard(
    onDeleteClick: (() -> Unit)? = null,
    position: Int,
    listMood: MutableList<MoodModel>
) {

    val mood = listMood[position].mood
    val description = listMood[position].description


    Card(
        colors = CardDefaults.cardColors(containerColor = Gray_My),
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        shape = RoundedCornerShape(10.dp),
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
                        pressed = true
                        onDeleteClick?.invoke()
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