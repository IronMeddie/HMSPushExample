package com.ironmeddie.testapp

import android.util.Log
import com.huawei.hms.push.HmsMessageService
import com.huawei.hms.push.RemoteMessage
import io.appmetrica.analytics.push.provider.hms.AppMetricaHmsMessagingService


class HMSPushMessagingService : HmsMessageService() {

    override fun onNewToken(token: String?) {
        super.onNewToken(token)
        Log.d("Token = ", token.toString())
        AppMetricaHmsMessagingService().processToken(this, token ?: return)
    }


    override fun onMessageReceived(remoteMessage: RemoteMessage?) {
        super.onMessageReceived(remoteMessage)

        if (remoteMessage == null) return

        if (AppMetricaHmsMessagingService.isNotificationRelatedToSDK(remoteMessage)) {
            AppMetricaHmsMessagingService().processPush(this, remoteMessage)
        }
    }
}