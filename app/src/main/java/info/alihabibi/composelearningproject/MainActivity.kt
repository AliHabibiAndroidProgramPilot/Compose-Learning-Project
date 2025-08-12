package info.alihabibi.composelearningproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role
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
        val themeOption = listOf("Light Mode", "Nigh Mode", "System Default")
        val (radioSelectedOption, radioOnOptionSelected) = remember { mutableStateOf(themeOption[0]) }
        val (checkboxSelectedOption, checkboxOnOptionSelected) = remember { mutableStateOf(false) }
        val (switchSelectedOption, switchOnOptionSelected) = remember { mutableStateOf(false) }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .navigationBarsPadding()
                .statusBarsPadding(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp, 50.dp)
                    .selectableGroup(),
                verticalAlignment = Alignment.Bottom,
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                themeOption.forEach { text ->
                    Row(
                        modifier = Modifier
                            .weight(1f)
                            .selectable(
                                selected = (text == radioSelectedOption),
                                onClick = { radioOnOptionSelected(text) },
                                role = Role.RadioButton
                            )
                            .padding(horizontal = 8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RadioButton(
                            selected = (text == radioSelectedOption),
                            onClick = null
                        )
                        Spacer(Modifier.padding(8.dp))
                        Text(
                            text = text,
                            style = MaterialTheme.typography.bodyMedium.copy(fontSize = 16.sp)
                        )
                    }
                }
            }

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Checkbox(
                    checked = checkboxSelectedOption,
                    onCheckedChange = {
                        checkboxOnOptionSelected(it)
                    },
                    modifier = Modifier.padding(10.dp, 50.dp),
                    colors = CheckboxDefaults.colors(
                        checkedColor = Color.DarkGray,
                        uncheckedColor = Color.Black,
                        checkmarkColor = Color.White
                    )
                )

                Text(
                    text = "Accept The Privacy And Policy",
                    style = MaterialTheme.typography.bodyMedium.copy(fontSize = 16.sp)
                )
            }
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Switch(
                    checked = switchSelectedOption,
                    onCheckedChange = {
                        switchOnOptionSelected(it)
                    },
                    colors = SwitchDefaults.colors(
                        checkedTrackColor = Color.Black,
                        checkedThumbColor = Color.Yellow
                    )
                )
                Spacer(Modifier.padding(horizontal = 10.dp))
                Text(
                    text = "Accept The Privacy And Policy",
                    style = MaterialTheme.typography.bodyMedium.copy(fontSize = 16.sp)
                )
            }
        }
    }

    /*@Preview("Preview", widthDp = 450, heightDp = 800, showBackground = true)
    @Composable
    fun EnablePreview() {
        SetContentAndPreview()
    }*/

}