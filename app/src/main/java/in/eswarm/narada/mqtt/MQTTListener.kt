package `in`.eswarm.narada.mqtt

import android.util.Log
import io.moquette.interception.AbstractInterceptHandler
import io.moquette.interception.messages.*
import java.nio.charset.StandardCharsets

class MQTTServerListener : AbstractInterceptHandler() {

    companion object {
        const val TAG = "MQTTServerListener"
    }

    override fun getID(): String {
        return "MQTTServerListener"
    }

    override fun onConnect(msg: InterceptConnectMessage?) {
        Log.i(TAG, "onConnect :: ${msg?.username}")
    }

    override fun onDisconnect(msg: InterceptDisconnectMessage?) {
        Log.i(TAG, "onDisconnect :: ${msg?.username}")
    }

    override fun onConnectionLost(msg: InterceptConnectionLostMessage?) {
        Log.i(TAG, "onConnectionLost :: ${msg?.username}")
    }

    override fun onPublish(msg: InterceptPublishMessage) {
        val decodedPayload = msg.payload.toString(StandardCharsets.UTF_8)
        Log.i(TAG, "Received on topic: " + msg.topicName + " content: " + decodedPayload)
    }

    override fun onSubscribe(msg: InterceptSubscribeMessage?) {
        Log.i(TAG, "onSubscribe :: ${msg?.username} ${msg?.topicFilter} ")
    }

    override fun onUnsubscribe(msg: InterceptUnsubscribeMessage?) {
        Log.i(TAG, "onUnsubscribe :: ${msg?.username} ${msg?.topicFilter} ")
    }

    override fun onMessageAcknowledged(msg: InterceptAcknowledgedMessage?) {
        Log.i(TAG, "onMessageAcknowledged :: ${msg?.username} ${msg?.topic} ")
    }
}