package com.rootdevs.myapplication.services

import android.accessibilityservice.AccessibilityService
import android.accessibilityservice.AccessibilityServiceInfo
import android.util.Log
import android.view.accessibility.AccessibilityEvent
import android.view.accessibility.AccessibilityNodeInfo
import android.widget.Toast


class MyAccessibilityService : AccessibilityService() {

    override fun onServiceConnected() {
        super.onServiceConnected()
        val info = AccessibilityServiceInfo()
        info.eventTypes = AccessibilityEvent.TYPE_TOUCH_INTERACTION_START
        info.eventTypes = AccessibilityEvent.TYPE_TOUCH_INTERACTION_END
        info.eventTypes=AccessibilityEvent.TYPES_ALL_MASK
        info.feedbackType = AccessibilityServiceInfo.FEEDBACK_ALL_MASK
        info.packageNames = null
        setServiceInfo(info);
    }

    override fun onAccessibilityEvent(event: AccessibilityEvent?) {
        //Toast.makeText(baseContext, "EVENT", Toast.LENGTH_SHORT).show()
        if (event != null) {
            if (event.eventType == AccessibilityEvent.TYPE_WINDOW_CONTENT_CHANGED) {
                if (event.getPackageName().equals("com.whatsapp")) {
                    val currentNode = rootInActiveWindow
                    Log.v("Current Node Class: ", currentNode.javaClass.toString())
                    if (currentNode != null && currentNode.className == "android.widget.FrameLayout" && currentNode.getChild(
                            2
                        ) != null && currentNode.getChild(2).className == "android.widget.TextView" && currentNode.getChild(
                            2
                        ).contentDescription == "Search"
                    ) {
                        currentNode.getChild(2).performAction(AccessibilityNodeInfo.ACTION_CLICK)
                    }
                }
            }
        }
    }

    override fun onInterrupt() {
        TODO("Not yet implemented")
    }

}