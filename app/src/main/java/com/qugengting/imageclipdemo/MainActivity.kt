package com.qugengting.imageclipdemo

import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnStart.setOnClickListener {
            startActivityForResult(Intent(this@MainActivity, ClipActivity::class.java), 0)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        val bitmap = ClipActivity.bitmap.copy(Bitmap.Config.ARGB_8888, true)
        imgClip.setImageBitmap(bitmap)
    }
}