
package com.rootdevs.myapplication

import android.content.BroadcastReceiver
import android.content.Intent
import android.content.IntentFilter
import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.rootdevs.myapplication.services.BackGroundService
import com.rootdevs.myapplication.services.BootDeviceChecker
import com.rootdevs.myapplication.services.MyAccessibilityService


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        registerListener()
        val intent = Intent(applicationContext, MyAccessibilityService::class.java)
        startService(intent)
        finish()
    }

    fun registerListener(){
        val filter = IntentFilter(Intent.ACTION_SCREEN_ON)
        filter.addAction(Intent.ACTION_SCREEN_OFF)
        filter.addAction(Intent.ACTION_USER_PRESENT)
        val mReceiver: BroadcastReceiver = BootDeviceChecker()
        registerReceiver(mReceiver, filter)
    }
}