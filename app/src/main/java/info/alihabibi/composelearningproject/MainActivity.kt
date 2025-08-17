package info.alihabibi.composelearningproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Face
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
                .statusBarsPadding()
                .padding(10.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val navigationItems = listOf("Setting", "Profile", "Feed")
            var navigationItemsState by remember { mutableIntStateOf(1) }
            BottomAppBar {
                NavigationBar {
                    navigationItems.forEachIndexed { index, item ->
                        NavigationBarItem(
                            selected = (index == navigationItemsState),
                            onClick = {
                                navigationItemsState = index
                            },
                            icon = {
                                Icon(
                                    imageVector = when (index) {
                                        0 -> Icons.Rounded.Settings
                                        1 -> Icons.Rounded.Face
                                        2 -> Icons.Rounded.Notifications
                                        else -> Icons.Rounded.Face
                                    },
                                    contentDescription = null
                                )
                            },
                            label = {
                                Text(
                                    text = item,
                                    fontSize = 16.sp
                                )
                            }
                        )
                    }
                }
            }
        }
    }
}

/*@Preview("Preview", widthDp = 450, heightDp = 800, showBackground = true)
@Composable
fun EnablePreview() {
    SetContentAndPreview()
}*/