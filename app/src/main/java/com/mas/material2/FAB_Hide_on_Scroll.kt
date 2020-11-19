package com.mas.material2

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.view.animation.LinearInterpolator
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.view.ViewCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton


class FAB_Hide_on_Scroll(context: Context?, attrs: AttributeSet?) : FloatingActionButton.Behavior() {

    override fun onNestedScroll(coordinatorLayout: CoordinatorLayout, child: FloatingActionButton, target: View, dxConsumed: Int, dyConsumed: Int, dxUnconsumed: Int, dyUnconsumed: Int, type: Int, consumed: IntArray) {
        super.onNestedScroll(coordinatorLayout, child, target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed, type, consumed)
        if (dyConsumed > 0) {
            val layoutParams = child.layoutParams as CoordinatorLayout.LayoutParams
            val fab_rightMargin = layoutParams.rightMargin
            child.animate().translationX((child.height + fab_rightMargin).toFloat()).setInterpolator(LinearInterpolator()).start()
        } else if (dyConsumed < 0) {
            child.animate().translationX(0f).setInterpolator(LinearInterpolator()).start()
        }

    }

    override fun onStartNestedScroll(coordinatorLayout: CoordinatorLayout, child: FloatingActionButton, directTargetChild: View, target: View, nestedScrollAxes: Int): Boolean {
        return nestedScrollAxes == ViewCompat.SCROLL_AXIS_VERTICAL
    }
}
