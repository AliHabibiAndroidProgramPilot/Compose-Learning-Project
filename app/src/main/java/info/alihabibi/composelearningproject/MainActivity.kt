package info.alihabibi.composelearningproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowBack
import androidx.compose.material.icons.rounded.MoreVert
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

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
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TopAppBar(
                title = {
                    Text("Ali Habibi", fontWeight = FontWeight.Bold)
                },
                navigationIcon = {
                    IconButton(
                        {},
                        Modifier
                            .size(40.dp)
                            .padding(start = 10.dp)
                    ) {
                        Icon(
                            Icons.AutoMirrored.Rounded.ArrowBack,
                            null
                        )
                    }
                },
                actions = {
                    IconButton(
                        {},
                        Modifier
                            .size(40.dp)
                            .padding(end = 10.dp)
                    ) {
                        Icon(
                            Icons.Rounded.MoreVert,
                            null
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Blue,
                    navigationIconContentColor = Color.Green,
                    actionIconContentColor = Color.Magenta,
                    titleContentColor = Color.White
                )
            )

            /*Image(
                painterResource(R.drawable.android_kotlin), null, Modifier.size(100.dp)
            )
            Image(
                painterResource(R.drawable.android_kotlin), null, Modifier.size(100.dp)
            )
            Image(
                painterResource(R.drawable.android_kotlin), null, Modifier.size(100.dp)
            )
            Image(
                painterResource(R.drawable.android_kotlin), null, Modifier.size(100.dp)
            )
            Image(
                painterResource(R.drawable.android_kotlin), null, Modifier.size(100.dp)
            )
            Image(
                painterResource(R.drawable.android_kotlin), null, Modifier.size(120.dp)
            )
            Image(
                painterResource(R.drawable.android_kotlin), null, Modifier.size(120.dp)
            )
            Image(
                painterResource(R.drawable.android_kotlin), null, Modifier.size(120.dp)
            )
            Image(
                painterResource(R.drawable.android_kotlin), null, Modifier.size(120.dp)
            )
            Image(
                painterResource(R.drawable.android_kotlin), null, Modifier.size(120.dp)
            )
            Image(
                painterResource(R.drawable.android_kotlin), null, Modifier.size(120.dp)
            )
            Image(
                painterResource(R.drawable.android_kotlin), null, Modifier.size(120.dp)
            )
            Image(
                painterResource(R.drawable.android_kotlin), null, Modifier.size(120.dp)
            )
            Image(
                painterResource(R.drawable.android_kotlin), null, Modifier.size(120.dp)
            )
            Image(
                painterResource(R.drawable.android_kotlin), null, Modifier.size(120.dp)
            )
            Image(
                painterResource(R.drawable.android_kotlin), null, Modifier.size(120.dp)
            )*/
        }
    }

    /*@Preview("Preview", widthDp = 450, heightDp = 800, showBackground = true)
    @Composable
    fun EnablePreview() {
        SetContentAndPreview()
    }*/

}