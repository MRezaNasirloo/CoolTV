package com.tv.telero.rate

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tv.telero.R
import com.tv.telero.text.TextBox
import com.tv.telero.theme.TeleroColor
import java.util.Locale

@Composable
fun Rate(modifier: Modifier = Modifier, score: Float, from: Int, votes: Int) {
    Column(
        Modifier
            .padding(8.dp)
            .then(modifier),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Icon(
            modifier = Modifier.size(32.dp),
            imageVector = ImageVector.vectorResource(id = R.drawable.ic_star_fill_24),
            contentDescription = null,
            tint = TeleroColor.AmberA400,
        )
        Text(
            textAlign = TextAlign.Center,
            text = buildAnnotatedString {
                withStyle(
                    SpanStyle(
                        fontSize = 18.sp, fontWeight = FontWeight.Medium, letterSpacing = 0.sp,
                    )
                ) {
                    append(score.toString())
                }
                withStyle(
                    SpanStyle(
                        fontSize = 16.sp, fontWeight = FontWeight.Medium,
                        color = TeleroColor.NavyBlueLight,
                        letterSpacing = 0.sp
                    )
                ) {
                    append("/")
                    append(from.toString())
                    append("\n")
                }
                withStyle(
                    SpanStyle(
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Normal,
                        color = TeleroColor.Grey500,
                        letterSpacing = 0.sp
                    )
                ) {
                    append(votes.commafy())
                }
            }
        )
    }
}

@Composable
fun UserRate(caption: String, modifier: Modifier = Modifier) {
    Column(
        Modifier
            .padding(8.dp)
            .then(modifier),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Icon(
            modifier = Modifier.size(32.dp),
            imageVector = ImageVector.vectorResource(id = R.drawable.ic_star_outline_24),
            contentDescription = null,
            tint = TeleroColor.NavyBlueLight,
        )
        TextBox(
            modifier = Modifier.padding(top = 4.dp),
            style = MaterialTheme.typography.button,
            text = caption,
        )
    }
}

private fun Int.commafy(): String {
    return "%,d".format(this)
}

private fun Int.pretty(): String {
    val num = this
    return when {
        num in 0..999 -> toString()
        num in 1_000..999_999 -> (num / 1_000f).roundTo(1) + "K"
        num in 999_999..999_999_999 -> (num / 1_000_000f).roundTo(1) + "M"
        num > 999_999_999 -> (num / 1_000_000_000f).roundTo(1) + "B"
        else -> throw IllegalStateException("negative number is not supported: $num")
    }
}

fun Float.roundTo(n: Int): String {
    return "%.${n}f".format(Locale.ENGLISH, this).removeSuffix(".0")
}

@Suppress("UnusedPrivateMember")
private fun main() {
    println(12_345.pretty()) // -> 1K
    println(1000.pretty()) // -> 1K
    println(1049.pretty()) // -> 1K
    println(1051.pretty()) // -> 1.1K
    println(1101.pretty()) // -> 1.1K
    println(10_011.pretty()) // -> 100K
    println(100_000_011.pretty()) // -> 100M
    println(999_231_011.pretty()) // -> 999.2M
    println(1_000_000_000.pretty()) // -> 1B
//    println((-100000).pretty()) // error

    println(12_345.commafy())
    println(1000.commafy())
    println(1049.commafy())
    println(1051.commafy())
    println(1101.commafy())
    println(10_011.commafy())
    println(100_000_011.commafy())
    println(999_231_011.commafy())
    println(1_000_000_000.commafy())
    println((-100_000).commafy())
}
