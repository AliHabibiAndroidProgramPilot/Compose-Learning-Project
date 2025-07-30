package info.alihabibi.composelearningproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Column(modifier = Modifier.statusBarsPadding()) {
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 30.dp, top = 5.dp)
                        .background(Color.DarkGray)
                        .padding(20.dp),
                    text = "Ali, Welcome to Compose World",
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 24.sp,
                    color = colorResource(R.color.teal_700)
                )
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.Red)
                        .padding(30.dp),
                    text = "Ali Habibi",
                    fontStyle = FontStyle.Italic,
                    fontSize = 20.sp,
                    color = colorResource(R.color.white)
                )
                Text(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(colorResource(R.color.black))
                        .padding(30.dp),
                    text = "متن فارسی",
                    textAlign = TextAlign.Right,
                    fontStyle = FontStyle.Italic,
                    fontSize = 20.sp,
                    color = Color.Magenta
                )
            }
        }
    }

}