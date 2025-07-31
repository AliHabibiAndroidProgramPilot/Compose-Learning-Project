package info.alihabibi.composelearningproject

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
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
                Button(
                    { Toast.makeText(this@MainActivity, "test toast", Toast.LENGTH_LONG).show() },
                    Modifier
                        .padding(5.dp)
                        .fillMaxWidth()
                        .height(60.dp),
                    shape = RoundedCornerShape(20.dp, 5.dp, 20.dp, 5.dp),
                    colors = ButtonDefaults.buttonColors(Color.Black, Color.White)
                ) {
                    Text("Click", fontSize = 20.sp)
                }
            }
        }
    }

}