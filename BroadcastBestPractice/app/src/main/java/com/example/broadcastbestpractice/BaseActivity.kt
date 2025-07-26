package com.example.broadcastbestpractice

import android.annotation.SuppressLint
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.content.Context.RECEIVER_NOT_EXPORTED
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.WindowManager
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

open class BaseActivity : AppCompatActivity() {

    lateinit var receiver:ForceOfflineReceiver
 
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState) 
        ActivityCollector.addActivity(this) 
    }

    @SuppressLint("UnspecifiedRegisterReceiverFlag")
    override fun onResume() {
        super.onResume()
        Log.d("BaseActivity", "${this.localClassName} onResume - registering receiver")
        val intentFilter = IntentFilter()
        intentFilter.addAction("com.example.broadcastbestpractice.FORCE_OFFLINE")
        receiver = ForceOfflineReceiver()
        
        // 由于minSdk已设置为33 (Android 13)，可以直接使用RECEIVER_NOT_EXPORTED
        registerReceiver(receiver, intentFilter, Context.RECEIVER_NOT_EXPORTED)
        Log.d("BaseActivity", "Registered receiver with RECEIVER_NOT_EXPORTED flag")
    }

    override fun onPause() {
        super.onPause()
        Log.d("BaseActivity", "${this.localClassName} onPause - unregistering receiver")
        if (::receiver.isInitialized) {
            try {
                unregisterReceiver(receiver)
                Log.d("BaseActivity", "Receiver unregistered successfully")
            } catch (e: Exception) {
                Log.e("BaseActivity", "Error unregistering receiver: ${e.message}")
            }
        } else {
            Log.d("BaseActivity", "Receiver not initialized, skipping unregister")
        }
    }

    override fun onDestroy() {
        super.onDestroy() 
        ActivityCollector.removeActivity(this) 
    }


    inner class ForceOfflineReceiver: BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            Log.d("ForceOfflineReceiver", "Broadcast received! Action: ${intent?.action}")
            Log.d("ForceOfflineReceiver", "Current activity: ${this@BaseActivity.localClassName}")
            Toast.makeText(this@BaseActivity, "Broadcast received!", Toast.LENGTH_SHORT).show()

            if (context != null) {
                Log.d("ForceOfflineReceiver", "Showing force offline dialog")
                AlertDialog.Builder(this@BaseActivity).apply {
                    setTitle("Warning")
                    setMessage("You are forced to be offline. Please try to login again")
                    setCancelable(false)
                    setPositiveButton("OK") {_,_ ->
                        Log.d("ForceOfflineReceiver", "Force offline confirmed, finishing all activities")
                        ActivityCollector.finishAll()
                        val i = Intent(this@BaseActivity, LoginActivity::class.java)
                        this@BaseActivity.startActivity(i)
                        Log.d("ForceOfflineReceiver", "Started LoginActivity")
                    }
                    create()
                    show()
                }
            } else {
                Log.e("ForceOfflineReceiver", "Context is null, cannot show dialog")
            }
        }
    }
 
}