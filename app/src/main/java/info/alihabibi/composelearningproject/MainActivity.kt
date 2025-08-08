package info.alihabibi.composelearningproject

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
            Icon(
                painterResource(R.drawable.ic_call),
                null,
                Modifier
                    .size(62.dp)
                    .padding(10.dp),
                Color.Green
            )

            IconButton(
                {
                    Toast.makeText(this@MainActivity, "Icon Button", Toast.LENGTH_SHORT).show()
                },
                Modifier
                    .size(70.dp)
                    .padding(10.dp)
            ) {
                Icon(
                    Icons.Outlined.LocationOn,
                    null,
                    Modifier
                        .size(42.dp)
                        .padding(5.dp)
                )
            }

            Text(
                "Ali Habibi",
                Modifier
                    .padding(top = 10.dp)
                    .clickable(true) {
                        Toast.makeText(this@MainActivity, "Icon Button", Toast.LENGTH_SHORT).show()
                    },
                Color.Black,
                26.sp
            )
        }
    }

    @Preview("Preview", widthDp = 450, heightDp = 800, showBackground = true)
    @Composable
    fun EnablePreview() {
        SetContentAndPreview()
    }

}