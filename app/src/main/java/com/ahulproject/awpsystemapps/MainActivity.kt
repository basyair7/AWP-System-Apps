package com.ahulproject.awpsystemapps

import android.content.DialogInterface
import android.content.Intent
import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.cardview.widget.CardView
import com.ahulproject.awpsystemapps.SensorMonitor.SensorlistActivity

class MainActivity : AppCompatActivity() {
    lateinit var mButtonSensor : CardView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        mButtonSensor = findViewById(R.id.sensor_id)

        // if one click cardview, open sensor real-time
        mButtonSensor.setOnClickListener {
            val i = Intent(this, SensorlistActivity::class.java)
            startActivity(i)
            finish()
        }
    }

    override fun onBackPressed() {
        AlertDialog.Builder(this)
            .setMessage("Are you sure you want to exit?")
            .setIcon(R.mipmap.ic_launcher)
            .setCancelable(false)
            .setPositiveButton("Yes", DialogInterface.OnClickListener { dialog, which -> System.exit(0) })
            .setNegativeButton("No", null)
            .show()
    }
}


