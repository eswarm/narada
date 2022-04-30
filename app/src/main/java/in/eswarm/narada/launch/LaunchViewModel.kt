package `in`.eswarm.narada.launch

import `in`.eswarm.narada.mqtt.MQTTService
import `in`.eswarm.narada.util.NetworkUtil
import android.content.Context
import androidx.lifecycle.ViewModel

class LaunchViewModel : ViewModel() {

    fun startServer(context: Context) {
        MQTTService.start(context)
    }

    fun stopServer(context: Context) {
        MQTTService.stop(context)
    }

    fun getLocalIpAddress(): String? {
        return NetworkUtil.getLocalIpAddress()
    }
}