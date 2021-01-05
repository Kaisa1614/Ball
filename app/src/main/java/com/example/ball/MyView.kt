package com.example.ball


import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import kotlinx.android.synthetic.main.activity_main.*
import android.view.View


class MyView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {
    var x1 = 100f
    var y1 = 100f
    val paint = Paint()

    override fun onDraw(canvas: Canvas?) {
        paint.color = Color.YELLOW
        canvas?.drawOval( x1, y1, x1 + 100, y1 + 100, paint)
        super.onDraw(canvas)
    }
    fun setXY(x:Float, y: Float): Unit
    {
       x1 = x
       y1 = y
        invalidate()
    }

}


