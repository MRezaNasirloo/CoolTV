package com.tv.telero.image

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.tv.telero.app.R

@Preview
@Composable
fun PreviewBackdrop() {
    Backdrop {
        painterResource(id = R.drawable.poster_the_suicide_squad)
    }
}
