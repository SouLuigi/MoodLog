package com.example.moodlog.components

import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import com.example.moodlog.ui.theme.White_My
import com.example.moodlog.ui.theme.Yellow_My

@Composable
fun ButtonSave(
    onClick: () -> Unit,
    modifier: Modifier,
    text: String

){
    Button(
        onClick = onClick,
        modifier,
        colors = ButtonDefaults.buttonColors(
            containerColor = Yellow_My,
            contentColor = White_My
        )
    ) {
        Text(
            text = text,
            fontSize = 18.sp
        )
    }
}