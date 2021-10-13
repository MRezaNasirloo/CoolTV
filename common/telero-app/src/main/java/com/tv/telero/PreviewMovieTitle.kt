package com.tv.telero

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.tv.telero.theme.CoolTvTheme

@Preview
@Composable
fun PreviewMovieTitle() {
    CoolTvTheme {
        MovieTitle(
            title = "Ford v Ferrari",
            listOf(
                "2012",
                "PG-13",
                "1h 23min",
                "Released",
            ),
        )
    }
}
