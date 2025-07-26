package com.example.prc

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.prc.databinding.ResultProfileBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ResultProfileBinding;


    private var count = 0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ResultProfileBinding.inflate(layoutInflater)
        val view:LinearLayout = binding.root
        setContentView(view)


    }

}