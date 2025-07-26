package com.example.resultforactivity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    lateinit var launcher1: ActivityResultLauncher<Intent>
    lateinit var launcher2: ActivityResultLauncher<Int>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var tvInfo:TextView = findViewById(R.id.tvInfo)
        val btnOpenActivityTwo:Button = findViewById(R.id.button2)

        // 注册OneActivity启动回调
        launcher1 = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()) {
            // 当OneActivity返回时，检查状态码
            if (it.resultCode == RESULT_OK) {
                // 取回OneActivity传回的结果
                tvInfo.text = it.data?.getStringExtra(OneActivity.OneActivity_RESULT_CODE)?:"没有提取出信息"
            } else {
                tvInfo.text = "用户取消了操作"
            }
        }

        val btnOpenActivityOne:Button = findViewById(R.id.button1)
        btnOpenActivityOne.setOnClickListener {
            // 生成要启动OneActivity的Intent
            val intent = Intent(this,OneActivity::class.java)
            intent.putExtra(OneActivity.OneActivity_INPUT_KEY,"这是从主Activity传来的数据")
            // 启动OneActivity
            launcher1.launch(intent)
        }

//        // 注册自定义启动器回调
//        launcher2 =
    }
}