//package com.example.moodlog.components
//
//
//import androidx.compose.foundation.background
//import androidx.compose.foundation.clickable
//import androidx.compose.foundation.layout.Arrangement
//import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.layout.PaddingValues
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.size
//import androidx.compose.foundation.lazy.grid.GridCells
//import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.unit.dp
//import com.example.moodlog.domain.MoodType
//import com.example.moodlog.ui.theme.Gray_My
//
//
//@Composable
//fun EmojiGrid(
//    modifier: Modifier = Modifier,
//    emojis: List<MoodType>,
//    onEmojiSelect:(MoodType) -> Unit,
//    selectEmoji: MoodType?
//
//){
//    LazyVerticalGrid(
//        columns = GridCells.Fixed(4),
//        contentPadding = PaddingValues(horizontal = 16.dp),
//        modifier = Modifier.fillMaxWidth().background(Gray_My),
//        horizontalArrangement = Arrangement.spacedBy(16.dp),
//        verticalArrangement = Arrangement.spacedBy(16.dp),
//
//    ) {
//        items(emojis) { emoji ->
//            Box(
//                modifier = Modifier
//                    .size(64.dp)
//                    .background(Gray_My, RoundedCornerShape(8.dp))
//                    .clickable{onEmojiSelect(emoji)}
//                    .background(
//                        if (emoji == selectEmoji)
//                    ),
//                contentAlignment = Alignment.Center
//            ) {  }
//        }
//    }
//}