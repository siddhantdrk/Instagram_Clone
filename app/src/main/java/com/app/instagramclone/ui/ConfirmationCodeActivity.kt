package com.app.instagramclone.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.app.instagramclone.R
import kotlinx.android.synthetic.main.activity_confirmation_code.*

class ConfirmationCodeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirmation_code)
        nextMb.setOnClickListener {
            startActivity(Intent(this, UserProfileActivity::class.java))
        }
    }
}