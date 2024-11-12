package ro.pub.cs.systems.eim.practicaltest01var03

import android.app.NotificationChannel
import android.app.NotificationManager
import androidx.core.app.NotificationCompat
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import android.app.PendingIntent
import android.app.Service
import android.content.Intent
import android.os.IBinder

class PracticalTest01Var03Service : Service() {
    private val scope = CoroutineScope(Dispatchers.IO)

    @Override
    override fun onCreate() {
        super.onCreate()
        val notification_manager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
        notification_manager.createNotificationChannel(NotificationChannel("PracticalTest01Var03", "PracticalTest01Var03", NotificationManager.IMPORTANCE_DEFAULT))

        val notification_intent = Intent(this, PracticalTest01Var03MainActivity::class.java)
        val pending_intent = PendingIntent.getActivity(this, 0, notification_intent, PendingIntent.FLAG_IMMUTABLE)
        val notification = NotificationCompat.Builder(this, "PracticalTest01Var03")
            .setContentTitle("PracticalTest01Var03")
            .setContentText("Service is running")
            .setSmallIcon(R.drawable.ic_launcher_background)
            .setContentIntent(pending_intent)
            .setAutoCancel(true)
            .build()

        startForeground(1, notification)
    }

    override fun onBind(intent: Intent): IBinder? {
        return null
    }

    @Override
    override fun onStartCommand(intent: Intent, flags: Int, startId: Int): Int {


        return Service.START_REDELIVER_INTENT
    }
}