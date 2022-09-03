package com.rootdevs.myapplication.services

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import android.widget.Toast
import java.lang.UnsupportedOperationException

class BackGroundService : Service() {
    override fun onBind(p0: Intent?): IBinder? {
        throw UnsupportedOperationException("NOT YET IMPLEMENTED")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        onTaskRemoved(intent)
        //Toast.makeText(baseContext, "Background Service running", Toast.LENGTH_SHORT).show()
        //Thread.sleep(5000)
        Log.v("Service", "RUNNING")
        return START_STICKY
    }

    override fun onTaskRemoved(rootIntent: Intent?) {
        val restartServiceIntent  = Intent(applicationContext, javaClass)
        restartServiceIntent.setPackage(packageName)
        startService(restartServiceIntent)
        super.onTaskRemoved(rootIntent)
    }
}