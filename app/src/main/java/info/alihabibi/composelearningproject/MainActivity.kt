package info.alihabibi.composelearningproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
            Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            TextField(
                value = "Text Filed",
                onValueChange = {

                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(40.dp, 20.dp)
            )
            OutlinedTextField(
                value = "Text Filed",
                onValueChange = {

                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 40.dp, 20.dp),
                label = {
                    Text(
                        text = "Name",
                        fontSize = 16.sp
                    )
                }
            )
            BasicTextField(
                value = "Text Filed",
                onValueChange = {

                },
                modifier = Modifier
                    .fillMaxWidth()
                    .size(150.dp, 90.dp)
                    .padding(horizontal = 40.dp, 20.dp)
                    .background(Color.DarkGray)
            )
        }
    }

    /*@Preview("Preview", widthDp = 450, heightDp = 800, showBackground = true)
    @Composable
    fun EnablePreview() {
        SetContentAndPreview()
    }*/

}