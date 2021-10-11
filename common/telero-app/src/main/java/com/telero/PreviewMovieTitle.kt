package com.telero

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.tv.telero.MovieTitle
import com.tv.telero.theme.CoolTvTheme

@Preview
@Composable
fun PreviewMovieTitle() {
    CoolTvTheme {
        MovieTitle(
            title = "Ford v Ferrari",
            year = 2012,
            certification = "PG-13",
            118
        )
    }
}
