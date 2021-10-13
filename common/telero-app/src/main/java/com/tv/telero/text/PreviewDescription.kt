package com.tv.telero.text

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.tv.telero.theme.CoolTvTheme

@Composable
@Preview(name = "Description", group = "Text", showBackground = true)
fun PreviewDescription() {
    CoolTvTheme {
        Description(
            title = "Weddings are basically funerals with cake. " +
                "Energy is not eternal in chaos, the country of conclusion, " +
                "or nirvana, but everywhere. " +
                "Bloody, tender pudding is best garnished with sweet anchovy essence." +
                "Place the zucchini in a casserole, and mash up thoroughly with grey whiskey." +
                "Nutty, salted pudding is best rinsed with packaged champaign." +
                "Rinse each side of the steak with eleven pounds of walnut."
        )
    }
}
