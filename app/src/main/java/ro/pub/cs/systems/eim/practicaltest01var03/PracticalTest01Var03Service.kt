package ro.pub.cs.systems.eim.practicaltest01var03

import android.app.Service
import android.content.Intent
import android.os.IBinder

class PracticalTest01Var03Service : Service() {
    @Override
    override fun onCreate() {
        super.onCreate()

    }

    override fun onBind(intent: Intent): IBinder? {
        return null
    }

    @Override
    override fun onStartCommand(intent: Intent, flags: Int, startId: Int): Int {


        return Service.START_REDELIVER_INTENT
    }
}