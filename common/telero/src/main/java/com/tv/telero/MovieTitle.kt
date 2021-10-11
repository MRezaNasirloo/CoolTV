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

@Composable
fun MovieTitle(title: String, year: Int?, certification: String?, runtime: Int?) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        TextBox(
            text = title,
            style = MaterialTheme.typography.h5.copy(fontWeight = FontWeight.Medium),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
        )
        Spacer(modifier = Modifier.height(8.dp))
        Row {
            ProvideTextStyle(value = MaterialTheme.typography.caption) {
                if (year != null) {
                    TextBox(
                        text = year.toString(),
                        maxLines = 1,
                    )
                }
                Spacer(modifier = Modifier.width(16.dp))
                if (certification != null) {
                    TextBox(
                        text = certification,
                        maxLines = 1,
                    )
                }
                Spacer(modifier = Modifier.width(16.dp))
                if (runtime != null) {
                    TextBox(
                        text = runtime.pretty(),
                        maxLines = 1,
                    )
                }
            }
        }
    }
}

/**
 * Converts raw minutes value to human readable time
 * e.g : 138 -> 2h 18min
 */
private fun Int.pretty(): String {
    val hours = this / 60
    val minutes = this % 60
    return "${hours}h ${minutes}min"
}
