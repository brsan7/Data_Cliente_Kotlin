package com.brsan7.datacliente.pushnotification

import android.util.Log
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class MyFirebaseMessageService : FirebaseMessagingService() {

    private val tag = "firebaseMsggService"
    override fun onMessageReceived(msg: RemoteMessage) {
        Log.i(tag,msg.from.toString())
        if (msg.notification != null){
            this.showNotification("7",
                msg.notification?.title.toString(),
                msg.notification?.body.toString())
        }
    }
}