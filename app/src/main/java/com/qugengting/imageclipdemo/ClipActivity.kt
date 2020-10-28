package com.qugengting.imageclipdemo

import android.app.Activity
import android.graphics.Bitmap
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_clip.*

class ClipActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        ) // full screen
        setContentView(R.layout.activity_clip)
    }

    fun clip(view: View?) {
        bitmap = clipLayout.clip()
        setResult(Activity.RESULT_OK)
        finish()
    }

    companion object {
        lateinit var bitmap: Bitmap
    }
}