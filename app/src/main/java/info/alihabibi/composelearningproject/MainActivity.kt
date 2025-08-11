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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDirection
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

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun SetContentAndPreview() {
        Column(
            Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Button(
                {},
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 40.dp),
                shape = RoundedCornerShape(15.dp)
            ) {
                Text("Normal Button", fontSize = 19.sp)
            }

            OutlinedButton(
                {},
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 40.dp),
                shape = RoundedCornerShape(15.dp)
            ) {
                Text("Outlined Button", fontSize = 19.sp)
            }

            TextButton(
                {},
                shape = RoundedCornerShape(10.dp)
            ) {
                Text(
                    "Text Button",
                    fontSize = 19.sp
                )
            }
        }
    }

    /*@Preview("Preview", widthDp = 450, heightDp = 800, showBackground = true)
    @Composable
    fun EnablePreview() {
        SetContentAndPreview()
    }*/

}