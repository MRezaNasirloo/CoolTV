package com.tv.telero.text

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.tv.telero.TextBox

@Composable
fun Description(title: String, modifier: Modifier = Modifier) {
    TextBox(
        text = title,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp, horizontal = 16.dp)
            .then(modifier),
        style = MaterialTheme.typography.body1,
    )
}
