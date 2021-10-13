package com.tv.telero.text

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.tv.telero.theme.CoolTvTheme

@Composable
@Preview(name = "TextBox", group = "Text", showBackground = true)
fun PreviewTextBox() {
    CoolTvTheme {
        TextBox(text = "Sunt devatioes consumere varius, clemens lactaes.")
    }
}
