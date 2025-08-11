package info.alihabibi.composelearningproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
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
        val textStyle = TextStyle(
            color = Color.Black,
            fontSize = 16.sp
        )
        val radioButtons = listOf("Light Mode", "Night Mode", "System Default")
        val selectedItem = remember {
            mutableStateOf("Light Mode")
        }
        Row(
            Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            radioButtons.forEach { item ->
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(
                        (selectedItem.value == item),
                        {
                            selectedItem.value = item
                        }
                    )
                    Text(
                        item,
                        modifier = Modifier.padding(start = 10.dp),
                        style = textStyle
                    )
                }
            }
        }
    }

    /*@Preview("Preview", widthDp = 450, heightDp = 800, showBackground = true)
    @Composable
    fun EnablePreview() {
        SetContentAndPreview()
    }*/

}