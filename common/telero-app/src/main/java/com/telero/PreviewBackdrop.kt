package com.telero

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.tv.telero.Backdrop

@Preview
@Composable
fun PreviewBackdrop() {
    Backdrop {
        painterResource(id = R.drawable.poster_black_widow)
    }
}
