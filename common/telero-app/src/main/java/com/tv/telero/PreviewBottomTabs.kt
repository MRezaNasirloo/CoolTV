package com.tv.telero

import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tv.telero.theme.CoolTvTheme

@Preview
@Composable
fun PreviewBottomTabs() {
    val tabs = listOf(
        Tab(title = "Home", icon = R.drawable.ic_home_24),
        Tab(title = "Profile", icon = R.drawable.ic_person_24),
        Tab(title = "Setting", icon = R.drawable.ic_settings_24),
    )
    CoolTvTheme {
        BottomTabs(modifier = Modifier.requiredHeight(56.dp), tabs, "") {}
    }
}
