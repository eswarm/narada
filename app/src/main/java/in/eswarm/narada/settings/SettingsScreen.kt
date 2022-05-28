package `in`.eswarm.narada.settings

import `in`.eswarm.narada.preferences.AppPreferences
import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

@Composable
fun SettingsScreen(
    settingsViewModel: SettingsViewModel
) {

    return Column {

        val showDialog = remember { mutableStateOf(false) }

        val mqttPort =
            settingsViewModel.appPreferences.mqttPort.collectAsState(initial = AppPreferences.MQTT_PORT_DEFAULT)
        val wsEnabled =
            settingsViewModel.appPreferences.wsEnabled.collectAsState(initial = AppPreferences.WS_ENABLED_DEFAULT)
        val wsPort =
            settingsViewModel.appPreferences.wsPort.collectAsState(initial = AppPreferences.WS_PORT_DEFAULT)
        val wsPath =
            settingsViewModel.appPreferences.wsPath.collectAsState(initial = AppPreferences.WS_PATH_DEFAULT)
        val authEnabled =
            settingsViewModel.appPreferences.authEnabled.collectAsState(initial = AppPreferences.AUTH_ENABLED_DEFAULT)
        val userName = settingsViewModel.appPreferences.userName.collectAsState(initial = "")
        val password = settingsViewModel.appPreferences.password.collectAsState(initial = "")

        val dialogTitle = rememberSaveable {
            mutableStateOf("")
        }

        val labelTitle = rememberSaveable {
            mutableStateOf("")
        }

        val defValue = rememberSaveable {
            mutableStateOf("")
        }

        val isNumber = rememberSaveable {
            mutableStateOf(false)
        }

        val dialogAction = rememberSaveable {
            mutableStateOf(
                { _: String -> }
            )
        }

        val context = LocalContext.current



        if (showDialog.value) {
            CustomDialog(
                openDialogCustom = showDialog,
                dialogTitle.value,
                dialogTitle.value,
                defValue.value,
                isNumber.value,
                onOkRequest = dialogAction.value
            )
        }

        Text(
            text = "Settings",
            style = MaterialTheme.typography.h3,
            modifier = Modifier.padding(top = 16.dp, bottom = 4.dp, start = 16.dp, end = 16.dp)
        )

        Text(
            text = "Settings are applied only on server restart",
            style = MaterialTheme.typography.body1,
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 4.dp)
        )

        Divider()

        RegularPreference(title = "MQTT Port", subtitle = mqttPort.value.toString(), onClick = {


            showDialog.value = true
            dialogTitle.value = "MQTT Port"
            labelTitle.value = "Port"
            defValue.value = mqttPort.value.toString()
            isNumber.value = true
            dialogAction.value = { value: String ->
                val isSuccess = settingsViewModel.setMqttPort(value)
                if (!isSuccess) {
                    Toast.makeText(
                        context,
                        "Port should be a number greater than 1023",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
        })

        Divider()

        SwitchPreference(
            title = "Enable Websocket",
            subtitle = wsEnabled.value.toString(),
            checked = wsEnabled.value,
            onCheckedChange = {
                settingsViewModel.setWSEnabled(it)
            })

        Divider()

        RegularPreference(title = "Websocket Port", subtitle = wsPort.value.toString(), onClick = {
            showDialog.value = true
            dialogTitle.value = "Websocket Port"
            labelTitle.value = "Port"
            defValue.value = wsPort.value.toString()
            isNumber.value = true
            dialogAction.value = { value ->
                val isSuccess = settingsViewModel.setWSPort(value)
                if (!isSuccess) {
                    Toast.makeText(
                        context,
                        "Port should be a number greater than 1023",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
        })

        Divider()

        RegularPreference(title = "Websocket Path", subtitle = wsPath.value, onClick = {
            showDialog.value = true
            dialogTitle.value = "Websocket Path"
            labelTitle.value = "Path"
            defValue.value = wsPath.value
            isNumber.value = false
            dialogAction.value = { value ->
                settingsViewModel.setWSPath(value)
            }
        })

        Divider()

        SwitchPreference(
            title = "Enable Authentication",
            subtitle = authEnabled.value.toString(),
            checked = authEnabled.value,
            onCheckedChange = { value: Boolean ->
                settingsViewModel.setAuthEnabled(value)
            })

        Divider()

        RegularPreference(title = "Username", subtitle = userName.value, onClick = {
            showDialog.value = true
            dialogTitle.value = "Username"
            labelTitle.value = "Username"
            isNumber.value = false
            defValue.value = userName.value
            dialogAction.value = { value ->
                settingsViewModel.setUserName(value)
            }
        })

        Divider()

        RegularPreference(title = "Password", subtitle = password.value, onClick = {
            showDialog.value = true
            dialogTitle.value = "Password"
            labelTitle.value = "Password"
            isNumber.value = false
            defValue.value = password.value
            dialogAction.value = { value ->
                settingsViewModel.setPassword(value)
            }
        })
    }

}

/*
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    NaradaMQTTBrokerTheme {
        SettingsScreen()
    }
}
*/
