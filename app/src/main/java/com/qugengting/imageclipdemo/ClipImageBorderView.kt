package com.qugengting.imageclipdemo

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.TypedValue
import android.view.View

class ClipImageBorderView(context: Context?) : View(context, null, 0) {
    /**
     * 水平方向与View的边距
     */
    private var mHorizontalPadding = 0

    /**
     * 垂直方向与View的边距
     */
    private var mVerticalPadding = 0

    /**
     * 绘制的矩形的宽度
     */
    private var mWidth = 0

    /**
     * 边框的颜色
     */
    private val mBorderColor = Color.parseColor("#1FB9D4")

    /**
     * 边框的宽度 单位dp
     */
    private var mBorderWidth = 2
    private val mPaint: Paint
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        // 计算矩形区域的宽度
        mWidth = width - 2 * mHorizontalPadding
        //相当于2寸照片的宽高比
        val height = (628f / 413f) * mWidth
        // 计算距离屏幕垂直边界 的边距
        mVerticalPadding = ((getHeight() - height) / 2).toInt()
        mPaint.color = Color.parseColor("#aa000000")
        mPaint.style = Paint.Style.FILL
        // 绘制左边1
        canvas.drawRect(0f, 0f, mHorizontalPadding.toFloat(), getHeight().toFloat(), mPaint)
        // 绘制右边2
        canvas.drawRect(
            width - mHorizontalPadding.toFloat(), 0f, width.toFloat(),
            getHeight().toFloat(), mPaint
        )
        // 绘制上边3
        canvas.drawRect(
            mHorizontalPadding.toFloat(), 0f, width - mHorizontalPadding.toFloat(),
            mVerticalPadding.toFloat(), mPaint
        )
        // 绘制下边4
        canvas.drawRect(
            mHorizontalPadding.toFloat(), getHeight() - mVerticalPadding.toFloat(),
            width - mHorizontalPadding.toFloat(), getHeight().toFloat(), mPaint
        )
        // 绘制外边框
        mPaint.color = mBorderColor
        mPaint.strokeWidth = mBorderWidth.toFloat()
        mPaint.style = Paint.Style.STROKE
        canvas.drawRect(
            mHorizontalPadding.toFloat(),
            mVerticalPadding.toFloat(),
            (width - mHorizontalPadding).toFloat(),
            getHeight() - mVerticalPadding.toFloat(),
            mPaint
        )
    }

    fun setHorizontalPadding(mHorizontalPadding: Int) {
        this.mHorizontalPadding = mHorizontalPadding
    }

    init {
        mBorderWidth = TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP, mBorderWidth.toFloat(),
            resources.displayMetrics
        ).toInt()
        mPaint = Paint()
        mPaint.isAntiAlias = true
    }
}