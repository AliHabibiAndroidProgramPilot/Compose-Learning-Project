package info.alihabibi.composelearningproject

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {

    private var usernameTextFiled = mutableStateOf(TextFieldValue())

    private var passwordTextFiled = mutableStateOf(TextFieldValue())

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
                .verticalScroll(rememberScrollState())
                .statusBarsPadding(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Surface(
                Modifier
                    .width(240.dp)
                    .height(250.dp)
                    .padding(vertical = 20.dp),
                CircleShape,
                shadowElevation = 25.dp
            ) {
                Image(
                    painterResource(R.drawable.android_kotlin),
                    null,
                    Modifier.fillMaxSize(),
                    Alignment.Center,
                    ContentScale.FillBounds
                )
            }

            LoginInputTextFiled(usernameTextFiled, false)

            LoginInputTextFiled(passwordTextFiled, true)

            Button(
                {
                    if (usernameTextFiled.value.text.isNotEmpty() || passwordTextFiled.value.text.isNotEmpty())
                        Toast.makeText(
                            this@MainActivity,
                            "${usernameTextFiled.value.text} \n ${passwordTextFiled.value.text}",
                            Toast.LENGTH_SHORT
                        ).show()
                },
                Modifier
                    .fillMaxWidth(0.8f)
                    .padding(vertical = 20.dp),
                colors = ButtonDefaults.buttonColors(
                    contentColor = Color.White
                )
            ) {
                Text("Login", fontSize = 20.sp)
            }
        }
    }

    @Composable
    fun LoginInputTextFiled(textValue: MutableState<TextFieldValue>, isPassword: Boolean) {
        val textStyle = TextStyle(
            Color.Black,
            18.sp,
            textAlign = TextAlign.Center
        )
        if (!isPassword)
            TextField(
                textValue.value,
                { textValue.value = it },
                Modifier
                    .fillMaxSize(0.8f)
                    .padding(vertical = 20.dp),
                textStyle = textStyle,
                label = {
                    Text("UserName")
                }
            )
        else
            TextField(
                textValue.value,
                { textValue.value = it },
                Modifier
                    .fillMaxSize(0.8f)
                    .padding(vertical = 20.dp),
                textStyle = textStyle,
                label = {
                    Text("Password")
                },
                keyboardOptions = KeyboardOptions(
                    autoCorrectEnabled = false,
                    keyboardType = KeyboardType.Password
                ),
                visualTransformation = PasswordVisualTransformation()
            )
    }

    @Preview("Preview", widthDp = 450, heightDp = 800, showBackground = true)
    @Composable
    fun EnablePreview() {
        SetContentAndPreview()
    }

}