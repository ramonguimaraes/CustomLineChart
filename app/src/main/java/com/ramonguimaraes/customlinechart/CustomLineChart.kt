package com.ramonguimaraes.customlinechart

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.cardview.widget.CardView

class CustomLineChart(context: Context, attrs: AttributeSet) : CardView(context, attrs) {

    private val list: MutableList<Triple<Float, Int, Long>> = mutableListOf()
    private val container: LinearLayout

    init {
        container = LinearLayout(context)
        container.layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.MATCH_PARENT
        )
        container.setBackgroundColor(context.resources.getColor(R.color.grey))
        container.weightSum = 100f
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        this.radius = 25f
        if (container.parent != null) {
            (container.parent as ViewGroup).removeView(container)
        }
        this.addView(container)
    }

    fun addItem(item: Triple<Float, Int, Long>) {
        list.add(item)
        list.sortBy { it.third }

        container.removeAllViews()
        list.forEach {
            container.addView(createChildView(it.first, it.second))
        }
    }

    private fun createChildView(weight: Float, color: Int): LinearLayout {
        val layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.WRAP_CONTENT,
            LinearLayout.LayoutParams.MATCH_PARENT,
            weight
        )
        val view = LinearLayout(context)
        view.layoutParams = layoutParams
        view.setBackgroundColor(resources.getColor(color))
        return view
    }
}
