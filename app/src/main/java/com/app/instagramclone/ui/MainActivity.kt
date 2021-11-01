package com.app.instagramclone.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.app.instagramclone.R
import com.app.instagramclone.fragment.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction().add(R.id.mainContainerFl, HomeFragment())
            .addToBackStack("Home").commit()


        bottomNav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.home -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.mainContainerFl, HomeFragment())
                        .addToBackStack("Home").commit()
                    true
                }
                R.id.search -> {
                    supportFragmentManager.beginTransaction().replace(
                        R.id.mainContainerFl, SearchFragment()
                    )
                        .addToBackStack("Search").commit()
                    true
                }
                R.id.camera -> {
                    supportFragmentManager.beginTransaction().replace(
                        R.id.mainContainerFl, CameraFragment()
                    )
                        .addToBackStack("Camera").commit()
                    true
                }
                R.id.notification -> {
                    supportFragmentManager.beginTransaction().replace(
                        R.id.mainContainerFl, NotificationFragment()
                    )
                        .addToBackStack("Notification").commit()
                    true
                }
                R.id.profile -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.mainContainerFl, ProfileFragment())
                        .addToBackStack("Profile").commit()
                    true
                }
                else -> false
            }
        }
    }
}