package com.wd.tech.app

import android.app.Application
import com.wd.tech.apis.Apis
import com.wd.tech.netWork.RetrofitManager

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        RetrofitManager.instance.init(Apis.BASE_URL)
    }
}