package `in`.eswarm.narada.launch

import `in`.eswarm.narada.R
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.navigation.NavController

@OptIn(ExperimentalUnitApi::class)
@Composable
fun LaunchScreen(
    launchViewModel: LaunchViewModel,
    navController: NavController
) {
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = { navController.navigate("settings") }) {
                /* FAB content */
                Icon(
                    Icons.Filled.Settings,
                    contentDescription = stringResource(id = R.string.settings),
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
                Text(stringResource(id = R.string.app_name))
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
                Text(launchViewModel.serverStatus(), lineHeight = TextUnit(24f, TextUnitType.Sp))
            }

            Row(modifier = Modifier.padding(vertical = Dp(4f))) {
                Text(
                    stringResource(id = R.string.ip_address),
                    style = MaterialTheme.typography.subtitle1
                )
                Spacer(modifier = Modifier.weight(1f))
                Text(launchViewModel.getLocalIpAddress() ?: "-")
            }

            Row(modifier = Modifier.padding(vertical = Dp(4f))) {
                Text(
                    stringResource(id = R.string.clients_connected),
                    style = MaterialTheme.typography.subtitle1
                )
                Spacer(modifier = Modifier.weight(1f))
                Text(launchViewModel.clientsCount.value.toString())
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
                    val buttonText =
                        if (launchViewModel.isServerRunning.value) stringResource(id = R.string.stop_server)
                        else stringResource(id = R.string.start_server)
                    Text(buttonText)
                }
            }

            Text(stringResource(id = R.string.logs), style = MaterialTheme.typography.h5)

            LogView(logs = launchViewModel.logs)
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