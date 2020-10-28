package com.qugengting.imageclipdemo

import android.content.Context
import android.graphics.Bitmap
import android.util.AttributeSet
import android.util.TypedValue
import android.view.ViewGroup
import android.widget.RelativeLayout
import androidx.core.content.res.ResourcesCompat
import com.shizhefei.view.largeimage.LargeImageView

class ClipImageLayout(
    context: Context?,
    attrs: AttributeSet?
) : RelativeLayout(context, attrs) {
    private val mZoomImageView: LargeImageView = LargeImageView(context)
    private val mClipImageView: ClipImageBorderView = ClipImageBorderView(context)

    /**
     * 裁切图片
     */
    fun clip(): Bitmap {
        return mZoomImageView.clip()
    }

    init {
        mZoomImageView.setImageDrawable(
            ResourcesCompat.getDrawable(
                resources,
                R.drawable.haha,
                null
            )
        )
        val lp: ViewGroup.LayoutParams = LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )
        val dm = resources.displayMetrics
        val horizontalPadding =
            TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24f, dm).toInt()
        val width = dm.widthPixels - horizontalPadding * 2
        val height = (628f / 413f) * width
        val params = LayoutParams(width, height.toInt())
        params.addRule(CENTER_HORIZONTAL, TRUE)
        params.addRule(CENTER_VERTICAL, TRUE)
        this.addView(mZoomImageView, params)
        this.addView(mClipImageView, lp)
        mClipImageView.setHorizontalPadding(horizontalPadding)
    }
}