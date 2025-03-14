package `in`.eswarm.narada.launch

import android.Manifest
import android.os.Build
import android.os.Build.VERSION_CODES.TIRAMISU
import `in`.eswarm.narada.R
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.navigation.NavController
import androidx.compose.ui.unit.dp
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberPermissionState

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun LaunchScreen(
    launchViewModel: LaunchViewModel, navController: NavController
) {
    val notifPermissionState = rememberPermissionState(Manifest.permission.POST_NOTIFICATIONS)

    Scaffold(floatingActionButton = {
        FloatingActionButton(onClick = { navController.navigate("settings") }) {
            Icon(
                Icons.Filled.Settings,
                contentDescription = stringResource(id = R.string.settings),
            )
        }
    }, isFloatingActionButtonDocked = true, bottomBar = {
        BottomAppBar(
            cutoutShape = MaterialTheme.shapes.small.copy(
                CornerSize(percent = 50)
            )
        ) {}
    }, topBar = {
        TopAppBar(
            title = { Text(stringResource(id = R.string.app_name)) },
            modifier = Modifier.windowInsetsPadding(WindowInsets.statusBars)
        )
    }) { innerPadding ->

        Column(modifier = Modifier.padding(innerPadding)) {

            Row(modifier = Modifier.padding(vertical = Dp(4f))) {
                Text(
                    "State", style = MaterialTheme.typography.subtitle1
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
                    }, modifier = Modifier
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

            if (Build.VERSION.SDK_INT < TIRAMISU || notifPermissionState.status.isGranted) {
                LogView(logs = launchViewModel.logs)
            } else {
                Column(modifier = Modifier.padding(vertical = Dp(16f))) {

                    Text(text = stringResource(id = R.string.no_notification_permission_description))

                    Button(modifier = Modifier
                        .padding(all = 16.dp)
                        .align(Alignment.CenterHorizontally),
                        onClick = { notifPermissionState.launchPermissionRequest() }) {
                        Text(text = stringResource(R.string.request_permission))
                    }
                }
            }
        }
    }
}
