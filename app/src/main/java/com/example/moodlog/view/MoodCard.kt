package com.example.moodlog.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.moodlog.R
import com.example.moodlog.model.MoodModel
import com.example.moodlog.ui.theme.Gray_My
import com.example.moodlog.ui.theme.Yellow_My


@Composable
fun MoodCard(
    position: Int,
    listaMood: List<MoodModel>
) {
    var moodModel = MoodModel()
    var isSelected by remember { mutableStateOf(false) }
    val mood = listaMood[position].mood
    val description = listaMood[position].description

    Card(
        colors = CardDefaults.cardColors(
            containerColor = Gray_My,
        ),

        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .clickable { isSelected = !isSelected },
        shape = RoundedCornerShape(10.dp),
        border = BorderStroke(
            width = 1.dp,
            color = if (isSelected) Yellow_My else Color.Transparent
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
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
                    text = description.toString(),
                    fontSize = 20.sp,
                    modifier = Modifier.weight(1f)
                )
                IconButton(onClick = {}) {
                    Icon(
                        painter = painterResource(id = R.drawable.icon_delete),
                        contentDescription = "Deletar Mood",
                    )
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp),
                horizontalArrangement = Arrangement.End
            ) {
                Text(
                    text = mood.toString(),
                    fontSize = 40.sp,
                    modifier = Modifier.padding(end = 10.dp)
                )
            }
        }
    }
}

//@Composable
//@Preview
//private fun MoodCardPreview() {
//    MoodCard()
//
//}