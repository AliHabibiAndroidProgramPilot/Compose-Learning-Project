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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
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
            AlertDialog(
                onDismissRequest = {

                },
                confirmButton = {
                    Text(
                        "Yes",
                        Modifier.clickable {
                            Toast.makeText(this@MainActivity, "YES", Toast.LENGTH_SHORT).show()
                        },
                        fontSize = 20.sp
                    )
                },
                dismissButton = {
                    Text(
                        "No",
                        Modifier.clickable {
                            Toast.makeText(this@MainActivity, "NO", Toast.LENGTH_SHORT).show()
                        },
                        fontSize = 20.sp
                    )
                },
                title = {
                    Text(
                        "Dialog Title",
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold
                    )
                },
                text = {
                    Text(
                        "Dialog Message is this and here so look it!",
                        fontSize = 20.sp,
                        fontFamily = FontFamily.Monospace,
                    )
                }
            )
        }
    }

    /*@Preview("Preview", widthDp = 450, heightDp = 800, showBackground = true)
    @Composable
    fun EnablePreview() {
        SetContentAndPreview()
    }*/

}