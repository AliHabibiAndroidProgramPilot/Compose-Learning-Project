package info.alihabibi.composelearningproject

import android.content.SharedPreferences
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Button
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Slider
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.util.fastRoundToInt

class MainActivity : ComponentActivity() {

    private lateinit var prefsManager: SharedPreferences

    private val textColors = arrayListOf("Color Red", "Color Magenta", "Color Blue")

    private val sliderStateValue = mutableFloatStateOf(20.0f)

    private val switchStateValue = mutableStateOf(false)

    private val radioStateValue = mutableStateOf(textColors.first())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        prefsManager = getSharedPreferences("SETTING_PREFS", MODE_PRIVATE)
        sliderStateValue.floatValue = prefsManager.getFloat("FONT_SIZE", 20.0f)
        switchStateValue.value = prefsManager.getBoolean("BOLD_TEXT", false)
        radioStateValue.value = prefsManager.getString("APP_THEME", textColors.first())!!
        setContent {
            SetContentAndPreview()
        }
    }

    @Composable
    fun SetContentAndPreview() {
        Column(
            modifier = Modifier
                .statusBarsPadding()
                .padding(10.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Slider(
                value = sliderStateValue.floatValue,
                onValueChange = {
                    sliderStateValue.floatValue = it
                },
                modifier = Modifier
                    .fillMaxWidth(0.9f),
                valueRange = (0.0f..60.0f)
            )

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                textColors.forEach {
                    Text(it, fontSize = 14.sp)
                    RadioButton(
                        selected = (radioStateValue.value == it),
                        onClick = {
                            radioStateValue.value = it
                        }
                    )
                }
            }

            Switch(
                checked = switchStateValue.value,
                onCheckedChange = {
                    switchStateValue.value = it
                },
                modifier = Modifier
                    .scale(1.2f)
                    .padding(vertical = 10.dp)
            )

            Text(
                sliderStateValue.floatValue.removeZero(sliderStateValue.floatValue),
                color = Color.Black,
                fontSize = 26.sp
            )

            Text(
                "Sample Text",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 40.dp),
                color = when (radioStateValue.value) {
                    textColors[0] -> Color.Red
                    textColors[1] -> Color.Magenta
                    textColors[2] -> Color.Blue
                    else -> Color.Red
                },
                textAlign = TextAlign.Center,
                fontFamily = FontFamily.SansSerif,
                fontSize = sliderStateValue.floatValue.sp,
                fontWeight = if (switchStateValue.value) FontWeight.ExtraBold else FontWeight.Normal
            )

            Button(
                onClick = {
                    prefsManager.edit().apply {
                        putFloat("FONT_SIZE", sliderStateValue.floatValue)
                        putBoolean("BOLD_TEXT", switchStateValue.value)
                        putString("APP_THEME", radioStateValue.value)
                        apply()
                    }
                },
                modifier = Modifier.fillMaxWidth(0.9f).padding(vertical = 40.dp),
                shape = RectangleShape
            ) {
                Text(
                    "Save Settings",
                    fontSize = 22.sp
                )
            }
        }
    }

    private infix fun Float.removeZero(floatNumber: Float): String =
        floatNumber.fastRoundToInt().toString()

}

/*@Preview("Preview", widthDp = 450, heightDp = 800, showBackground = true)
@Composable
fun EnablePreview() {
    SetContentAndPreview()
}*/