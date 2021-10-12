package com.telero

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.tv.telero.Chip
import com.tv.telero.ChipGroup
import com.tv.telero.theme.CoolTvTheme

@Composable
@Preview(name = "Single Chip", group = "Chip", showBackground = true)
fun PreviewChip() {
    CoolTvTheme {
        Chip(text = "Lixas potus Consiliums sunt paluss de fatalis habitio.Est talis lapsus")
    }
}

@Composable
@Preview(name = "Chip Group", group = "Chip", showBackground = true, fontScale = 1f)
fun PreviewChipGroup() {
    CoolTvTheme {
        ChipGroup(
            chips = listOf(
                "bursa",
                "historia",
                "Canis",
                "Quadrata",
                "Armarium",
                "Lapsus",
                "Fortis",
                "Deus",
                "Brabeuta",
                "Musa",
                "Particula",
                "Abactor",
                "Urias",
            )
        )
    }
}
