package com.example.moodlog.components


import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.focusGroup
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.moodlog.domain.MoodType
import com.example.moodlog.ui.theme.Blue_My
import com.example.moodlog.ui.theme.ShapeBoxEmojiGrid
import com.example.moodlog.ui.theme.White_My
import com.example.moodlog.ui.theme.Yellow_My


@Composable
fun EmojiGrid(
    modifier: Modifier,
    emojis: List<MoodType>,
    onEmojiSelect: (MoodType) -> Unit,
    selectedEmoji: MoodType?

) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(4),
        contentPadding = PaddingValues(horizontal = 16.dp),
        modifier = Modifier
            .padding(16.dp, 0.dp, 16.dp, 16.dp)
            .fillMaxWidth()
            .background(White_My, RoundedCornerShape(12.dp)),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp),
    ) {
        items(emojis) { emoji ->
            Box(
                modifier = Modifier
                    .padding(0.dp, 6.dp, 0.dp, 6.dp)
                    .size(width = 60.dp, height = 60.dp)
                    .clickable { onEmojiSelect(emoji) }
                    .background(
                        if (emoji == selectedEmoji) Color.LightGray else Color.Transparent,
                        shape = ShapeBoxEmojiGrid.small
                    ),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = emoji.symbol,
                    fontSize = 40.sp,
                    fontWeight = FontWeight.Bold,
                )
            }
        }
    }
}