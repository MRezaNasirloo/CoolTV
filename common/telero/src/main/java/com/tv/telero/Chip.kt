package com.tv.telero

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.LocalContentColor
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.tv.telero.theme.TeleroColor

@Composable
fun Chip(text: String, modifier: Modifier = Modifier) {
    // There is a need for custom theme implementation here
    val contentColor = if (MaterialTheme.colors.isLight) {
        TeleroColor.Grey800
    } else {
        TeleroColor.Grey500
    }
    CompositionLocalProvider(LocalContentColor provides contentColor) {
        TextBox(
            text = text,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            style = MaterialTheme.typography.body2,
            modifier = modifier
                .border(1.dp, LocalContentColor.current, RoundedCornerShape(50))
                .padding(horizontal = 12.dp, vertical = 6.dp)
        )
    }
}

@Composable
fun ChipGroup(chips: List<String>) {
    Layout(
        modifier = Modifier.padding(horizontal = 12.dp),
        content = {
            chips.forEach {
                Chip(text = it, Modifier.padding(4.dp))
            }
        },
        measurePolicy = { measurables, constraints ->
            var rowWidth = 0
            var tallestRow = 0
            var overallHeight = 0
            val placeables = measurables.mapIndexed { index, measurable ->
                measurable.measure(constraints).also { placeable ->
                    if (index == 0) overallHeight += placeable.height
                    if (rowWidth + placeable.width > constraints.maxWidth) {
                        if (rowWidth > tallestRow) {
                            tallestRow = rowWidth
                        }
                        rowWidth = placeable.width
                        overallHeight += placeable.height
                    } else {
                        rowWidth += placeable.width
                    }
                }
            }

            layout(tallestRow, overallHeight) {
                var yAxis = 0
                var xAxis = 0
                placeables.forEach { placeable ->
                    if (xAxis + placeable.width > constraints.maxWidth) {
                        xAxis = 0
                        yAxis += placeable.height
                    }
                    placeable.placeRelative(xAxis, yAxis)
                    xAxis += placeable.width
                }
            }
        }
    )
}
