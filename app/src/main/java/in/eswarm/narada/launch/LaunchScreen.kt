package `in`.eswarm.narada.launch

import `in`.eswarm.narada.ui.theme.NaradaMQTTBrokerTheme
import `in`.eswarm.narada.ui.theme.biscuitColor
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType

@OptIn(ExperimentalUnitApi::class)
@Composable
fun LaunchScreen(
    serverStatus: String,
    clientsConnected: Int,
    launchViewModel: LaunchViewModel
) {
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = { /* ... */ }) {
                /* FAB content */
                Icon(
                    Icons.Filled.Settings,
                    contentDescription = "Settings",
                )
            }
        },
        isFloatingActionButtonDocked = true,
        bottomBar = {
            BottomAppBar(
                // Defaults to null, that is, No cutout
                cutoutShape = MaterialTheme.shapes.small.copy(
                    CornerSize(percent = 50)
                )
            ) {
                Text("Narada : MQTT Broker")
            }
        }
    ) {

        Column(modifier = Modifier.padding(top = Dp(32f), start = Dp(16f), end = Dp(16f))) {

            Row(modifier = Modifier.padding(vertical = Dp(4f))) {
                Text(
                    "State",
                    style = MaterialTheme.typography.subtitle1
                )
                Spacer(modifier = Modifier.weight(1f))
                Text(serverStatus, lineHeight = TextUnit(24f, TextUnitType.Sp))
            }

            Row(modifier = Modifier.padding(vertical = Dp(4f))) {
                Text(
                    "IP Address(Local)",
                    style = MaterialTheme.typography.subtitle1
                )
                Spacer(modifier = Modifier.weight(1f))
                Text(launchViewModel.getLocalIpAddress() ?: "-")
            }

            Row(modifier = Modifier.padding(vertical = Dp(4f))) {
                Text(
                    "Clients Connected",
                    style = MaterialTheme.typography.subtitle1
                )
                Spacer(modifier = Modifier.weight(1f))
                Text(clientsConnected.toString())
            }

            Row(modifier = Modifier.padding(vertical = Dp(16f))) {
                val context = LocalContext.current
                Button(
                    onClick = {
                        launchViewModel.toggleServer(context)
                    },
                    modifier = Modifier
                        .padding(horizontal = Dp(16f))
                        .weight(1f)
                ) {
                    val buttonText = if (launchViewModel.isServerRunning.value) "Stop Server"
                    else "Start Server"
                    Text(buttonText)
                }

                /*
                Button(
                    onClick = { launchViewModel.stopServer(context) },
                    modifier = Modifier
                        .padding(horizontal = Dp(8f))
                        .weight(1f)
                ) {
                    Text(text = "Stop Server")
                }

                 */
            }

            Text("Logs", style = MaterialTheme.typography.h5)

            NaradaMQTTBrokerTheme(darkTheme = true) {
                Text(
                    launchViewModel.logs.joinToString(),
                    color = biscuitColor,
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(0.85f)
                        .verticalScroll(rememberScrollState())
                        .padding(Dp(8f))
                )
            }

        }
    }
}


/*
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    NaradaMQTTBrokerTheme {
        val context = LocalContext.current
        LaunchScreen("Running", 0, LaunchViewModel(context))
    }
}

 */