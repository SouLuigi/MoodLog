package com.example.moodlog.components


import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import com.example.moodlog.ui.theme.Blue_My
import com.example.moodlog.ui.theme.Gray_My
import com.example.moodlog.ui.theme.ShapeTextBox
import com.example.moodlog.ui.theme.White_My
import com.example.moodlog.ui.theme.Yellow_My


@Composable
fun TextBox(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier,
    label: String,
    maxLines: Int,
    keyboardType: KeyboardType
) {
    OutlinedTextField(
        value = value,
        onValueChange,
        modifier,
        label = {
            Text(text = label)
        },
        maxLines = maxLines,
        colors = TextFieldDefaults.colors(
            cursorColor = Yellow_My,
            unfocusedLabelColor = Blue_My,
            focusedLabelColor = Yellow_My,
            unfocusedContainerColor = Gray_My,
            focusedContainerColor = White_My,
            unfocusedIndicatorColor = Blue_My,
            focusedIndicatorColor = Yellow_My

        ),

        shape = ShapeTextBox.small,
        keyboardOptions = KeyboardOptions(
            keyboardType = keyboardType
        )
    )
}