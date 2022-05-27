package `in`.eswarm.narada.launch

import `in`.eswarm.narada.settings.SettingsScreen
import `in`.eswarm.narada.settings.SettingsViewModelFactory
import `in`.eswarm.narada.ui.theme.NaradaMQTTBrokerTheme
import `in`.eswarm.narada.util.NotificationUtil
import `in`.eswarm.narada.util.preferences
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

class LaunchActivity : ComponentActivity() {

    private val mainScope = MainScope()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        NotificationUtil.createNotificationChannel(this)

        mainScope.launch {
            preferences.setPassword()
        }

        setContent {
            NaradaMQTTBrokerTheme {
                val navController = rememberNavController()

                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val context = applicationContext
                    NavHost(navController = navController, startDestination = "home") {
                        composable("home") {
                            LaunchScreen(
                                viewModel(
                                    factory = LaunchViewModelFactory(
                                        context
                                    )
                                ), navController
                            )
                        }
                        composable("settings") {
                            SettingsScreen(
                                viewModel(
                                    factory = SettingsViewModelFactory(
                                        context
                                    )
                                )
                            )
                        }
                    }
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        mainScope.cancel()
    }
}