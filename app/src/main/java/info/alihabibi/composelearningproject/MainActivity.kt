package info.alihabibi.composelearningproject

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.media.AudioManager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Slider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlin.properties.Delegates

class MainActivity : ComponentActivity() {

    private var audioManager by Delegates.notNull<AudioManager>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SetContentAndPreview()
        }
        audioManager = getSystemService(AUDIO_SERVICE) as AudioManager
    }

    @Composable
    fun SetContentAndPreview() {
        val sliderState = remember {
            mutableFloatStateOf(audioManager.getStreamVolume(AudioManager.STREAM_MUSIC).toFloat())
        }
        DisposableEffect(Unit) {
            val receiver = object : BroadcastReceiver() {
                override fun onReceive(context: Context?, intent: Intent?) {
                    if (intent?.action == "android.media.VOLUME_CHANGED_ACTION") {
                        sliderState.floatValue =
                            audioManager.getStreamVolume(AudioManager.STREAM_MUSIC).toFloat()
                    }
                }
            }
            this@MainActivity.registerReceiver(
                receiver,
                IntentFilter("android.media.VOLUME_CHANGED_ACTION")
            )
            onDispose {
                this@MainActivity.unregisterReceiver(receiver)
            }
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .statusBarsPadding()
                .padding(start = 10.dp, top = 30.dp, end = 10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Slider(
                value = sliderState.floatValue,
                onValueChange = { progress ->
                    sliderState.floatValue = progress
                    audioManager.setStreamVolume(
                        AudioManager.STREAM_MUSIC,
                        progress.toInt(),
                        AudioManager.FLAG_PLAY_SOUND
                    )
                    audioManager.adjustVolume(
                        AudioManager.ADJUST_SAME,
                        AudioManager.FLAG_SHOW_UI
                    )
                },
                valueRange =
                    0.0f..audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC).toFloat()
            )
        }
    }

    /*@Preview("Preview", widthDp = 450, heightDp = 800, showBackground = true)
    @Composable
    fun EnablePreview() {
        SetContentAndPreview()
    }*/

}