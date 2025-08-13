package info.alihabibi.composelearningproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.unit.dp

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
        var indicatorProgress by remember { mutableFloatStateOf(0.0f) }
        val animatedProgress by animateFloatAsState(
            targetValue = indicatorProgress,
            animationSpec = tween(durationMillis = 2000, easing = LinearEasing),
            label = "Progress AAnimation"
        )
        LaunchedEffect(Unit) {
            indicatorProgress = 1f
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .statusBarsPadding()
                .padding(25.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CircularProgressIndicator(
                modifier = Modifier.size(70.dp),
                color = Color.Green
            )

            Spacer(Modifier.padding(vertical = 30.dp))

            LinearProgressIndicator(
                color = Color.DarkGray,
                strokeCap = StrokeCap.Round
            )

            Spacer(Modifier.padding(vertical = 30.dp))

            CircularProgressIndicator(
                progress = { 0.75f },
                modifier = Modifier.size(70.dp),
                color = Color.Gray
            )
            Spacer(Modifier.padding(vertical = 30.dp))

            LinearProgressIndicator(
                progress = { 0.20f },
                color = Color.DarkGray,
                strokeCap = StrokeCap.Round
            )

            Spacer(Modifier.padding(vertical = 30.dp))

            LinearProgressIndicator(
                progress = { animatedProgress },
                color = Color.Blue
            )

            Spacer(Modifier.padding(vertical = 30.dp))

            CircularProgressIndicator(
                modifier = Modifier.size(50.dp),
                progress = { animatedProgress },
                color = Color.Magenta
            )

            Spacer(Modifier.padding(vertical = 10.dp))

            OutlinedButton(
                onClick = {
                    indicatorProgress = if (indicatorProgress == 0f) 1f else 0f
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
                shape = RoundedCornerShape(10.dp),
                border = BorderStroke(0.8.dp, Color.Black),
                colors = ButtonDefaults.outlinedButtonColors(
                    contentColor = Color.Black
                )
            ) {
                Text("Re Progress")
            }
        }
    }
}

/*@Preview("Preview", widthDp = 450, heightDp = 800, showBackground = true)
@Composable
fun EnablePreview() {
    SetContentAndPreview()
}*/