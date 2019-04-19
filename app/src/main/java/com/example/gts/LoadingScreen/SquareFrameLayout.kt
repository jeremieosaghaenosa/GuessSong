package com.example.gts.LoadingScreen

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout


class SquareFrameLayout : FrameLayout {

    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {}

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val width = View.MeasureSpec.getSize(widthMeasureSpec)
        val height = View.MeasureSpec.getSize(heightMeasureSpec)

        if (width < height) {
            setMeasuredDimension(width, width)
            super.onMeasure(widthMeasureSpec, widthMeasureSpec)
        } else {
            setMeasuredDimension(height, height)
            super.onMeasure(heightMeasureSpec, heightMeasureSpec)
        }
    }
}
