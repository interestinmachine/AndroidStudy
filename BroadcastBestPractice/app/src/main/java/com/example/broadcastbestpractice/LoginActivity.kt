package com.example.broadcastbestpractice

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.broadcastbestpractice.databinding.ActivityLoginBinding

class LoginActivity : BaseActivity() {

    private lateinit var loginBind:ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        loginBind = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(loginBind.root)

        loginBind.login.setOnClickListener {
            val account = loginBind.accountEdit.text.toString()
            val password = loginBind.passwordEdit.text.toString()
            // 如果账号是admin且密码是123456，就认为登录成功
            if (account == "admin" && password == "123456") {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "account or password is invalid",
                    Toast.LENGTH_SHORT).show()
            }
        }

    }

}