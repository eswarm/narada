package `in`.eswarm.narada.mqtt

import `in`.eswarm.narada.MainActivity
import `in`.eswarm.narada.R
import `in`.eswarm.narada.util.NotificationUtil.FG_SERVICE_CHANNEL
import android.app.Notification
import android.app.PendingIntent
import android.app.Service
import android.content.Intent
import android.os.IBinder
import androidx.core.app.NotificationCompat
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class MQTTService : Service() {

    lateinit var threadExecutor: ExecutorService

    override fun onCreate() {
        super.onCreate()
        threadExecutor = Executors.newSingleThreadExecutor()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        threadExecutor.submit {
            MQTTInitializer.startMoquette()
        }

        val pendingIntent: PendingIntent =
            Intent(this, MainActivity::class.java).let { notificationIntent ->
                PendingIntent.getActivity(
                    this,
                    0,
                    notificationIntent,
                    PendingIntent.FLAG_CANCEL_CURRENT or PendingIntent.FLAG_IMMUTABLE
                )
            }

        val notification: Notification = NotificationCompat.Builder(this, FG_SERVICE_CHANNEL)
            .setContentTitle(getText(R.string.notification_mqtt_service_title))
            .setContentText(getText(R.string.notification_mqtt_service_content))
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setContentIntent(pendingIntent)
            .setTicker(getText(R.string.notification_mqtt_ticker))
            .build()

        // Notification ID cannot be 0.
        startForeground(NOT_SERVICE_ID, notification)

        return START_STICKY
    }

    override fun onBind(intent: Intent): IBinder? {
        return null
    }

    override fun onDestroy() {
        super.onDestroy()
        MQTTInitializer.stopMoquette()
        threadExecutor.shutdownNow()
    }

    companion object {
        const val NOT_SERVICE_ID = 987
        const val CHANNEL_DEFAULT = "channel"
    }
}