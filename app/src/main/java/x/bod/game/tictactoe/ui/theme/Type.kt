package x.bod.game.tictactoe.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import x.bod.game.tictactoe.R

val fontFamily = FontFamily(
    Font(R.font.rubik_regular, FontWeight.Normal),
    Font(R.font.rubik_semi_bold, FontWeight.SemiBold),
    Font(R.font.rubik_bold, FontWeight.Bold),
    Font(R.font.rubik_bold_italic, FontWeight.Bold, FontStyle.Italic),
    Font(R.font.rubik_medium, FontWeight.Medium),
)

val Typography = Typography(
    bodyLarge = TextStyle(fontFamily = fontFamily),
    bodyMedium = TextStyle(fontFamily = fontFamily),
    bodySmall = TextStyle(fontFamily = fontFamily),
    displayMedium = TextStyle(fontFamily = fontFamily),
    displayLarge = TextStyle(fontFamily = fontFamily),
    displaySmall = TextStyle(fontFamily = fontFamily),
    labelMedium = TextStyle(fontFamily = fontFamily),
    labelLarge = TextStyle(fontFamily = fontFamily),
    labelSmall = TextStyle(fontFamily = fontFamily),
)

