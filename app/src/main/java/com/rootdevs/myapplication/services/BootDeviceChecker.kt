package com.rootdevs.myapplication.services

import android.app.ActivityManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import android.widget.Toast
import androidx.core.content.ContextCompat.getSystemService


class BootDeviceChecker : BroadcastReceiver() {

    override fun onReceive(p0: Context, p1: Intent) {
        val action: String? = p1.action
        val message = "BootDeviceReceiver onReceive, action is $action"
        val intent = Intent(p0, BackGroundService::class.java)
        if (Intent.ACTION_BOOT_COMPLETED == action) {
            Toast.makeText(p0, "Device Booted", Toast.LENGTH_SHORT).show()
            startService(p0,intent)
        }
        if (Intent.ACTION_USER_PRESENT == action) {
            Toast.makeText(p0, "Device Unlocked", Toast.LENGTH_SHORT).show()
            startService(p0,intent)
        }
        if (Intent.ACTION_USER_UNLOCKED == action) {
            Toast.makeText(p0, "Device Unlocked", Toast.LENGTH_SHORT).show()
            startService(p0,intent)
        }
        if (Intent.ACTION_SCREEN_ON == action) {
            Toast.makeText(p0, "SCREEN ON", Toast.LENGTH_SHORT).show()
            startService(p0,intent)
        }
        if (Intent.ACTION_SCREEN_OFF == action) {
            Toast.makeText(p0, "SCREEN OFF", Toast.LENGTH_SHORT).show()
            startService(p0,intent)
        }

    }

    private fun startService(context: Context, intent:Intent){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            context.startForegroundService(intent);
        } else {
            context.startService(intent);
        }
    }

    /*private fun isMyServiceRunning(serviceClass: Class<*>): Boolean {
        val manager = getSystemService(Context.ACTIVITY_SERVICE, serviceClass) as ActivityManager?
        for (service in manager!!.getRunningServices(Int.MAX_VALUE)) {
            if (serviceClass.name == service.service.className) {
                return true
            }
        }
        return false
    }*/
}