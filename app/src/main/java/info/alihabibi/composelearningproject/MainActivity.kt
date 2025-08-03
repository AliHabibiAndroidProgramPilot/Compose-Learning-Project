package info.alihabibi.composelearningproject

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
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
                .navigationBarsPadding()
                .statusBarsPadding()
                .background(Color.DarkGray)
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Text(
                modifier = Modifier
                    .width(150.dp)
                    .height(60.dp)
                    .background(Color.DarkGray),
                text = "Ali, Welcome to Compose World",
                fontWeight = FontWeight.ExtraBold,
                fontSize = 24.sp,
                color = colorResource(R.color.teal_700)
            )

            Button(
                {
                    Toast.makeText(
                        this@MainActivity,
                        "test toast",
                        Toast.LENGTH_LONG
                    ).show()
                },
                Modifier
                    .width(160.dp)
                    .height(60.dp),
                shape = RoundedCornerShape(20.dp, 5.dp, 20.dp, 5.dp),
                colors = ButtonDefaults.buttonColors(Color.Black, Color.White)
            ) {
                Text("Click", fontSize = 20.sp)
            }

            Surface(
                Modifier
                    .padding(20.dp, 10.dp)
                    .background(Color.Black),
                shape = CircleShape
            ) {
                Image(
                    painterResource(R.drawable.android_kotlin),
                    null,
                    Modifier
                        .width(300.dp)
                        .height(250.dp),
                    contentScale = ContentScale.Crop
                )
            }
            Surface(
                Modifier
                    .padding(20.dp, 10.dp)
                    .background(Color.Black),
                shape = CircleShape
            ) {
                Image(
                    painterResource(R.drawable.android_kotlin),
                    null,
                    Modifier
                        .width(300.dp)
                        .height(250.dp),
                    contentScale = ContentScale.Crop
                )
            }
            Surface(
                Modifier
                    .padding(20.dp, 10.dp)
                    .background(Color.Black),
                shape = CircleShape
            ) {
                Image(
                    painterResource(R.drawable.android_kotlin),
                    null,
                    Modifier
                        .width(300.dp)
                        .height(250.dp),
                    contentScale = ContentScale.Crop
                )
            }
            Surface(
                Modifier
                    .padding(20.dp, 10.dp)
                    .background(Color.Black),
                shape = CircleShape
            ) {
                Image(
                    painterResource(R.drawable.android_kotlin),
                    null,
                    Modifier
                        .width(300.dp)
                        .height(250.dp),
                    contentScale = ContentScale.Crop
                )
            }
            Surface(
                Modifier
                    .padding(20.dp, 10.dp)
                    .background(Color.Black),
                shape = CircleShape
            ) {
                Image(
                    painterResource(R.drawable.android_kotlin),
                    null,
                    Modifier
                        .width(300.dp)
                        .height(250.dp),
                    contentScale = ContentScale.Crop
                )
            }
            Surface(
                Modifier
                    .padding(20.dp, 10.dp)
                    .background(Color.Black),
                shape = CircleShape
            ) {
                Image(
                    painterResource(R.drawable.android_kotlin),
                    null,
                    Modifier
                        .width(300.dp)
                        .height(250.dp),
                    contentScale = ContentScale.Crop
                )
            }
        }
    }

    @Preview("Preview", widthDp = 450, heightDp = 900, showBackground = true)
    @Composable
    fun EnablePreview() {
        SetContentAndPreview()
    }

}