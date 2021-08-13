package com.yoochangwonspro.intermediatereviewproject

import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class MyFirebaseMessagingService : FirebaseMessagingService() {

    override fun onNewToken(p0: String) {
        super.onNewToken(p0)
    }

    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        super.onMessageReceived(remoteMessage)

    }

    companion object {
        private const val CHANNEL_ID = "Chang Channel"
        private const val DESCRIPTION = "Chang 채널 입니다."
    }
}