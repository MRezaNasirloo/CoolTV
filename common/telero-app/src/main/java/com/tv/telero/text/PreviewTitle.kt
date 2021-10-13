package com.tv.telero.text

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.tv.telero.theme.CoolTvTheme

@Composable
@Preview(name = "Title", group = "Text", showBackground = true)
fun PreviewTitle() {
    CoolTvTheme {
        Title(title = "Summary")
    }
}
