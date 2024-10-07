package com.ironmeddie.testapp

import android.app.Application
import io.appmetrica.analytics.AppMetrica
import io.appmetrica.analytics.AppMetricaConfig
import io.appmetrica.analytics.push.AppMetricaPush
import io.appmetrica.analytics.push.provider.hms.HmsPushServiceControllerProvider

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        val config = AppMetricaConfig.newConfigBuilder(Secret.API_KEY)
            .withLogs()
            .build()
        AppMetrica.activate(this, config)
        AppMetricaPush.enableLogger()
        AppMetricaPush.activate(this,
//            FirebasePushServiceControllerProvider(this),
            HmsPushServiceControllerProvider(this)
            )

    }
}