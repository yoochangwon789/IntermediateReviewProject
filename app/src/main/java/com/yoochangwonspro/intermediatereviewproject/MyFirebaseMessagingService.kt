package com.yoochangwonspro.intermediatereviewproject

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class MyFirebaseMessagingService : FirebaseMessagingService() {

    override fun onNewToken(p0: String) {
        super.onNewToken(p0)
    }

    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        super.onMessageReceived(remoteMessage)

        createNotificationChannel()

        val type = remoteMessage.data["type"]
            ?.let { AlarmStatus.valueOf(it) }

        type ?: return

        val title = remoteMessage.data["title"]
        val message = remoteMessage.data["message"]

        NotificationManagerCompat.from(this)
            .notify(type.id, createNotification(type, title, message))
    }

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                CHANNEL_ID, CHANNEL_NAME, NotificationManager.IMPORTANCE_DEFAULT).apply {
                description = DESCRIPTION
            }

            val notificationManager: NotificationManager =
                getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }

    private fun createNotification(
        type: AlarmStatus,
        title: String?,
        message: String?,
    ): Notification {
        var builder = NotificationCompat.Builder(this, CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_baseline_notifications_24)
            .setContentTitle(title)
            .setContentText(message)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)

        when (type) {
            AlarmStatus.NORMAL -> Unit
            AlarmStatus.EXPANDABLE -> {}
            AlarmStatus.CUSTOM -> {}
        }

        return builder.build()
    }

    companion object {
        private const val CHANNEL_ID = "CHANG"
        private const val CHANNEL_NAME = "Chang Channel"
        private const val DESCRIPTION = "Chang 채널 입니다."
    }
}