package com.example.broadcastbestpractice

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.broadcastbestpractice.databinding.ActivityLoginBinding
import com.example.broadcastbestpractice.databinding.ActivityMainBinding

class MainActivity : BaseActivity() {


    private lateinit var mainBinding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)

        mainBinding.forceOffline.setOnClickListener {
            Toast.makeText(this, "Button clicked", Toast.LENGTH_SHORT).show()
            val intent = Intent("com.example.broadcastbestpractice.FORCE_OFFLINE")
            intent.setPackage(packageName) // 指定接收广播的应用包名
            Log.d("MainActivity", "Sending broadcast: com.example.broadcastbestpractice.FORCE_OFFLINE to package: $packageName")
            sendBroadcast(intent)
            Log.d("MainActivity", "Broadcast sent")
        }
    }
}