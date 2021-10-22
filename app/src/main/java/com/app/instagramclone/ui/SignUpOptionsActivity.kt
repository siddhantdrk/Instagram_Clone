package com.app.instagramclone.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.app.instagramclone.R
import kotlinx.android.synthetic.main.activity_sign_up_options.*

class SignUpOptionsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up_options)
        nextMb.setOnClickListener {
            startActivity(Intent(this, ConfirmationCodeActivity::class.java))
        }
    }
}