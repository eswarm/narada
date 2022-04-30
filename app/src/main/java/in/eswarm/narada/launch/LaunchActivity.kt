package `in`.eswarm.narada.launch

import `in`.eswarm.narada.ui.theme.NaradaMQTTBrokerTheme
import `in`.eswarm.narada.util.NotificationUtil
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier

class LaunchActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        NotificationUtil.createNotificationChannel(this)
        setContent {
            NaradaMQTTBrokerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    LaunchScreen("Running", 0)
                }
            }
        }
    }
}