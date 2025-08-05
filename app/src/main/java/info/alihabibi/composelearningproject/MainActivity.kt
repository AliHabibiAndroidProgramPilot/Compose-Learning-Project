package info.alihabibi.composelearningproject

import android.inputmethodservice.Keyboard
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextDirection
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
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
                .padding(10.dp)
                .statusBarsPadding()
                .navigationBarsPadding()
        ) {
            var textFieldText by remember {
                mutableStateOf(TextFieldValue())
            }

            CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
                TextField(
                    textFieldText,
                    {
                        textFieldText = it
                    },
                    textStyle = TextStyle(textDirection = TextDirection.Rtl),
                    label = {
                        Text(
                            text = "نام کاربری را اضافه کنید",
                            modifier = Modifier.fillMaxWidth(),
                            fontSize = 16.sp,
                            style = TextStyle(textDirection = TextDirection.Rtl)
                        )
                    },
                    placeholder = {
                        Text(
                            text = "نام کاربری را اضافه کنید",
                            modifier = Modifier.fillMaxWidth(),
                            fontSize = 16.sp,
                            style = TextStyle(textDirection = TextDirection.Rtl)
                        )
                    },
                    leadingIcon = {
                        Image(
                            painterResource(R.drawable.ic_call),
                            null,
                            Modifier
                                .width(24.dp)
                                .height(24.dp)
                        )
                    },
                    trailingIcon = {
                        Image(
                            painterResource(R.drawable.android_kotlin),
                            null,
                            Modifier
                                .width(24.dp)
                                .height(24.dp)
                        )
                    },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.NumberPassword),
                    visualTransformation = androidx.compose.ui.text.input.PasswordVisualTransformation()
                )
            }
        }
    }

    @Preview("Preview", widthDp = 450, heightDp = 800, showBackground = true)
    @Composable
    fun EnablePreview() {
        SetContentAndPreview()
    }

}