package com.tv.telero.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.airbnb.android.showkase.annotation.ShowkaseTypography

val Typography = Typography(
    defaultFontFamily = FontFamily.SansSerif,
    caption = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        letterSpacing = 0.4.sp,
        color = TeleroColor.Grey500,
    ))

@ShowkaseTypography
val h1 = Typography.h1

@ShowkaseTypography
val h2 = Typography.h2

@ShowkaseTypography
val h3 = Typography.h3

@ShowkaseTypography
val h4 = Typography.h4

@ShowkaseTypography
val h5 = Typography.h5

@ShowkaseTypography
val h6 = Typography.h6

@ShowkaseTypography
val subtitle1 = Typography.subtitle1

@ShowkaseTypography
val subtitle2 = Typography.subtitle2

@ShowkaseTypography
val body1 = Typography.body1

@ShowkaseTypography
val body2 = Typography.body2

@ShowkaseTypography
val button = Typography.button

@ShowkaseTypography
val caption = Typography.caption

@ShowkaseTypography
val overline = Typography.overline
