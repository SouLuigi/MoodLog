package com.example.moodlog.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ButtonSave(

){
    Button(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        onClick = {}
    ) {
        Text(
            text = "Salvar"
        )
    }
}