package info.alihabibi.composelearningproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.util.fastRoundToInt

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SetContentAndPreview()
        }
    }

    @Composable
    fun SetContentAndPreview() {
        val (onSliderStateValue, onSliderStateValueChanged) = remember {
            mutableFloatStateOf(0.0f)
        }

        Column(
            modifier = Modifier
                .statusBarsPadding()
                .padding(20.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Slider(
                value = onSliderStateValue,
                onValueChange = {
                    onSliderStateValueChanged(it)
                },
                modifier = Modifier
                    .fillMaxWidth(0.8f),
                valueRange = (0.0f..100.0f)
            )

            Text(
                onSliderStateValue.removeZero(onSliderStateValue),
                color = Color.Black,
                fontSize = 26.sp
            )
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