package com.minseo.callbank.view.map

import android.graphics.Color
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.Transformation
import com.minseo.callbank.R

class ToggleAnimation {

    companion object {
//        // 화살표시 회전 효과
//        fun toggleArrow(view: View, isExpanded: Boolean): Boolean {
//            if (isExpanded) {
//                view.animate().setDuration(200).rotation(180f)
//                return true
//            } else {
//                view.animate().setDuration(200).rotation(0f)
//                return false
//            }
//        }

        // 레이아웃 확장 효과
        fun expand(view1: View, view2: View) {
            val animation = expandAction(view1, view2)
            view1.startAnimation(animation)
            view2.startAnimation(animation)
        }

        private fun expandAction(view1: View, view2: View) : Animation {
            view2.measure(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
            val actualHeight = view2.measuredHeight
            val line = view1.findViewById<View>(R.id.divide)

            view2.layoutParams.height = 0
            view2.visibility = View.VISIBLE
            line.visibility = View.GONE
            view1.setBackgroundColor(Color.rgb(245, 245, 245))

            val animation = object : Animation() {
                override fun applyTransformation(interpolatedTime: Float, t: Transformation?) {
                    view2.layoutParams.height = if (interpolatedTime == 1f) ViewGroup.LayoutParams.WRAP_CONTENT
                    else (actualHeight * interpolatedTime).toInt()

                    view2.requestLayout()
                }
            }

            animation.duration = (actualHeight / view2.context.resources.displayMetrics.density).toLong()
            view2.startAnimation(animation)
            return animation
        }

        // 레이아웃 축소 효과
        fun collapse(view1: View, view2: View) {
            val actualHeight = view2.measuredHeight
            val line = view1.findViewById<View>(R.id.divide)

            line.visibility = View.VISIBLE
            view1.setBackgroundColor(Color.rgb(255, 255, 255))

            val animation = object : Animation() {
                override fun applyTransformation(interpolatedTime: Float, t: Transformation?) {
                    if (interpolatedTime == 1f) {
                        view2.visibility = View.GONE
                    } else {
                        view2.layoutParams.height = (actualHeight - (actualHeight * interpolatedTime)).toInt()
                        view2.requestLayout()
                    }
                }
            }

            animation.duration = (actualHeight / view2.context.resources.displayMetrics.density).toLong()
            view2.startAnimation(animation)
        }
    }
}