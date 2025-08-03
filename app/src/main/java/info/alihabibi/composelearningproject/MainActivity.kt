package info.alihabibi.composelearningproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
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
        Card(
            Modifier.padding(30.dp),
            elevation = CardDefaults.elevatedCardElevation(30.dp)
        ) {
            Column(
                Modifier.background(Color.White),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painterResource(R.drawable.android_kotlin),
                    null,
                    Modifier
                        .padding(top = 10.dp)
                        .width(160.dp)
                        .height(160.dp),
                    contentScale = ContentScale.FillWidth
                )

                Button(
                    {},
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
    }

    @Preview("Preview", showSystemUi = true, device = PIXEL_7_PRO)
    @Composable
    fun EnablePreview() {
        SetContentAndPreview()
    }

}