package `in`.eswarm.narada.mqtt

import `in`.eswarm.narada.log.LogData
import `in`.eswarm.narada.log.LogStream
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

    fun startMoquette(listener: MQTTServerListener, logStream: LogStream) {
        mqttBroker = Server()
        val userHandlers: List<InterceptHandler?> = listOf(listener)
        // TODO :: make the properties configurable
        mqttBroker?.startServer(MemoryConfig(Properties()), userHandlers)
        logStream.addLog(LogData("Starting Server"))

        // TODO :: Is this even relevant.
        println("Broker started press [CTRL+C] to stop")
        //Bind  a shutdown hook
        Runtime.getRuntime().addShutdownHook(Thread {
            println("Stopping broker")
            logStream.addLog(LogData("Stopping broker"))
            mqttBroker?.stopServer()
            logStream.addLog(LogData("Broker stopped"))
            println("Broker stopped")
        })

        Thread.sleep(20000)

        Log.i(TAG, "Before self publish")
        logStream.addLog(LogData("Before self publish"))
        val message = MqttMessageBuilders.publish()
            .topicName("/exit")
            .retained(true) //        qos(MqttQoS.AT_MOST_ONCE);
            //        qQos(MqttQoS.AT_LEAST_ONCE);
            .qos(MqttQoS.EXACTLY_ONCE)
            .payload(Unpooled.copiedBuffer("Hello World!!".toByteArray(StandardCharsets.UTF_8)))
            .build()

        mqttBroker?.internalPublish(message, "INTRLPUB")
        Log.i(TAG, "After self publish")
        logStream.addLog(LogData("After self publish"))
    }

    fun stopMoquette() {
        try {
            mqttBroker?.stopServer()
        } catch (e: Exception) {
            Log.e(TAG, e.message ?: "")
        }
    }
}