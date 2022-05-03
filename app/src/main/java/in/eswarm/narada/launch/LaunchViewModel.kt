package `in`.eswarm.narada.launch

import `in`.eswarm.narada.log.LogStream
import `in`.eswarm.narada.mqtt.MQTTService
import `in`.eswarm.narada.util.NetworkUtil
import `in`.eswarm.narada.util.getAppComponent
import android.content.Context
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class LaunchViewModel(val logStream: LogStream) : ViewModel() {

    var isServerRunning = mutableStateOf(false)
    var logs = mutableStateListOf<String>()

    init {
        viewModelScope.launch {
            logStream.logFlow.collect { logData ->
                logs.add(logData.msg + "\n")
            }
        }
    }

    private fun startServer(context: Context) {
        isServerRunning.value = true
        MQTTService.start(context)
    }

    private fun stopServer(context: Context) {
        isServerRunning.value = false
        MQTTService.stop(context)
    }

    fun getLocalIpAddress(): String? {
        return NetworkUtil.getLocalIpAddress()
    }

    fun toggleServer(context: Context) {
        if (isServerRunning.value) {
            stopServer(context)
        } else {
            startServer(context)
        }
    }
}

class LaunchViewModelFactory(private val context: Context) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        val logStream = context.getAppComponent().logStream
        return LaunchViewModel(logStream) as T
    }
}