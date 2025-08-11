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
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.twotone.Warning
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {

    private val isShowingDialog = mutableStateOf(false)

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
            if (isShowingDialog.value)
                Dialog()

            Button(
                {
                    isShowingDialog.value = true
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
                shape = RoundedCornerShape(15.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Black,
                    contentColor = Color.White
                )
            ) {
                Text("Show Dialog", fontSize = 19.sp)
            }
        }
    }

    @Composable
    fun Dialog() {
        AlertDialog(
            onDismissRequest = {
                isShowingDialog.value = false
            },
            confirmButton = {
                Text(
                    "Yes",
                    Modifier.clickable {
                        Toast.makeText(this@MainActivity, "YES", Toast.LENGTH_SHORT).show()
                        isShowingDialog.value = false
                    },
                    fontSize = 20.sp,
                    color = Color.White
                )
            },
            dismissButton = {
                Text(
                    "No",
                    Modifier
                        .clickable {
                        Toast.makeText(this@MainActivity, "NO", Toast.LENGTH_SHORT).show()
                        isShowingDialog.value = false
                    },
                    fontSize = 20.sp,
                    color = Color.White
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
                    "Dialog Message is this and here so look it!!",
                    fontSize = 20.sp
                )
            },
            containerColor = Color.DarkGray,
            titleContentColor = Color.White,
            textContentColor = Color.White,
            iconContentColor = Color.Magenta,
            icon = {
                Icon(
                    modifier = Modifier.size(35.dp),
                    imageVector = Icons.TwoTone.Warning,
                    contentDescription = null
                )
            }
        )
    }

    /*@Preview("Preview", widthDp = 450, heightDp = 800, showBackground = true)
    @Composable
    fun EnablePreview() {
        SetContentAndPreview()
    }*/

}