package com.tv.telero.rate

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.tv.telero.theme.CoolTvTheme

@Composable
@Preview(name = "Rate", group = "Rate", showBackground = true)
fun PreviewRate() {
    CoolTvTheme {
        Rate(score = 8.1f, from = 10, votes = 18_735)
    }
}

@Composable
@Preview(name = "User Rate", group = "Rate", showBackground = true)
fun PreviewUserRate() {
    CoolTvTheme {
        UserRate("Rate this")
    }
}
