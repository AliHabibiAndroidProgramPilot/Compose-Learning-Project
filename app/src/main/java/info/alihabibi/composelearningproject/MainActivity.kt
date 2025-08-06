package info.alihabibi.composelearningproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
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
            Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                Modifier
                    .width(220.dp)
                    .height(220.dp),
            ) {
                Image(
                    painterResource(R.drawable.android_kotlin),
                    null,
                    Modifier.fillMaxSize(),
                    contentScale = ContentScale.FillBounds
                )

                Box(
                    Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        "Ali Habibi",
                        Modifier.background(Color.Red),
                        fontSize = 22.sp
                    )
                }

                Box(
                    Modifier.fillMaxSize(),
                    contentAlignment = Alignment.TopEnd
                ) {
                    Image(
                        painterResource(R.drawable.android_kotlin),
                        null,
                        Modifier
                            .width(50.dp)
                            .height(50.dp),
                        contentScale = ContentScale.FillBounds
                    )
                }

                Box(
                    Modifier.fillMaxSize(),
                    contentAlignment = Alignment.BottomStart
                ) {
                    Image(
                        painterResource(R.drawable.android_kotlin),
                        null,
                        Modifier
                            .width(60.dp)
                            .height(50.dp)
                            .background(Color.DarkGray)
                            .padding(10.dp)
                    )
                }
            }
        }
    }

    @Preview("Preview", widthDp = 450, heightDp = 800, showBackground = true)
    @Composable
    fun EnablePreview() {
        SetContentAndPreview()
    }

}