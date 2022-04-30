package `in`.eswarm.narada.mqtt

import android.util.Log
import io.moquette.broker.Server
import io.moquette.broker.config.MemoryConfig
import io.moquette.interception.InterceptHandler
import io.netty.buffer.Unpooled
import io.netty.handler.codec.mqtt.MqttMessageBuilders
import io.netty.handler.codec.mqtt.MqttQoS
import java.nio.charset.StandardCharsets
import java.util.*

object MQTTWrapper {

    const val TAG = "MQTTInitializer"
    private var mqttBroker: Server? = null

    val clientsConnected: Int
        get() {
            return mqttBroker?.listConnectedClients()?.size ?: 0
        }

    fun startMoquette() {
        mqttBroker = Server()
        val userHandlers: List<InterceptHandler?> = listOf(MQTTServerListener())
        // TODO :: make the properties configurable
        mqttBroker?.startServer(MemoryConfig(Properties()), userHandlers)

        // TODO :: Is this even relevant.
        println("Broker started press [CTRL+C] to stop")
        //Bind  a shutdown hook
        Runtime.getRuntime().addShutdownHook(Thread {
            println("Stopping broker")
            mqttBroker?.stopServer()
            println("Broker stopped")
        })

        //Thread.sleep(20000)

        Log.i(TAG, "Before self publish")
        val message = MqttMessageBuilders.publish()
            .topicName("/exit")
            .retained(true) //        qos(MqttQoS.AT_MOST_ONCE);
            //        qQos(MqttQoS.AT_LEAST_ONCE);
            .qos(MqttQoS.EXACTLY_ONCE)
            .payload(Unpooled.copiedBuffer("Hello World!!".toByteArray(StandardCharsets.UTF_8)))
            .build()

        mqttBroker?.internalPublish(message, "INTRLPUB")
        Log.i(TAG, "After self publish")
    }

    fun stopMoquette() {
        try {
            mqttBroker?.stopServer()
        } catch (e: Exception) {
            Log.e(TAG, e.message ?: "")
        }
    }
}