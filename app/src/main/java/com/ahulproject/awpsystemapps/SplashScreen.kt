package com.ahulproject.awpsystemapps

import android.content.Intent
import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        Handler().postDelayed(Runnable {
            run {
                var i = Intent(this, MainActivity::class.java)
                startActivity(i)
                finish()
            }
        }, 5000)
    }
}