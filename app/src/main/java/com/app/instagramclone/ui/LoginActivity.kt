package com.app.instagramclone.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.app.instagramclone.R
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        SignUpTv.setOnClickListener {
            startActivity(Intent(this, SignUpOptionsActivity::class.java))
        }
        forgotPasswordTv.setOnClickListener {
            startActivity(Intent(this, ForgotPasswordActivity::class.java))
        }
        signInMb.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}