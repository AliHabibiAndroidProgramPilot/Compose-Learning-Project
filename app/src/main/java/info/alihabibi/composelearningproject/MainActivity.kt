package info.alihabibi.composelearningproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices.PIXEL_7_PRO
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

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
        Column(
            modifier = Modifier
                .fillMaxSize()
                .navigationBarsPadding()
                .statusBarsPadding()
                .background(Color.Green),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            var isShowingName by remember { mutableStateOf(true) }
            var name: String by remember {
                mutableStateOf("Ali Habibi")
            }
            Text(
                name,
                Modifier
                    .fillMaxWidth(0.8f)
                    .padding(10.dp, 20.dp)
                    .background(Color.DarkGray)
                    .padding(15.dp),
                Color.White,
                32.sp,
                textAlign = TextAlign.Center
            )

            Button(
                {
                    name = if (isShowingName)
                        "Recomposition"
                    else
                        "Ali Habibi"
                    isShowingName = !isShowingName
                },
                Modifier.padding(top = 28.dp),
                colors = ButtonDefaults.buttonColors(
                    Color.Magenta,
                    Color.White
                ),
                shape = RoundedCornerShape(18.dp)
            ) {
                Text(
                    "Click Here",
                    fontSize = 22.sp
                )
            }
        }

    }

    @Preview("Preview", showSystemUi = true, device = PIXEL_7_PRO)
    @Composable
    fun EnablePreview() {
        SetContentAndPreview()
    }

}