package com.tv.telero

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.MaterialTheme
import androidx.compose.material.ProvideTextStyle
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.tv.telero.text.TextBox

@Composable
fun MovieTitle(title: String, tags: List<String>) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp, horizontal = 16.dp)
    ) {
        TextBox(
            text = title,
            style = MaterialTheme.typography.h5.copy(fontWeight = FontWeight.Medium),
            maxLines = 3,
            overflow = TextOverflow.Ellipsis,
        )
        Spacer(modifier = Modifier.height(8.dp))

        ProvideTextStyle(value = MaterialTheme.typography.caption) {
            Row {
                tags.forEach { tag ->
                    TextBox(
                        text = tag,
                        maxLines = 1,
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                }
            }
        }
    }
}
