package com.yoochangwonspro.intermediatereviewproject

import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class MyFirebaseMessagingService : FirebaseMessagingService() {

    override fun onNewToken(p0: String) {
        super.onNewToken(p0)
    }

    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        super.onMessageReceived(remoteMessage)

        val type = remoteMessage.data["type"]
        val title = remoteMessage.data["title"]
        val message = remoteMessage.data["message"]
    }

    companion object {
        private const val CHANNEL_ID = "Chang Channel"
        private const val DESCRIPTION = "Chang 채널 입니다."
    }
}