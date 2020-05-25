package `in`.christophers.extra

import `in`.christophers.fragments.Home
import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import androidx.core.widget.NestedScrollView
import androidx.viewpager.widget.ViewPager
import kotlin.math.abs

class CustomViewPager(context1 : Context, attrs : AttributeSet) : ViewPager(context1,attrs) {

    private var mCurrentView : View ?= null

    override fun onTouchEvent(ev: MotionEvent?): Boolean {
        /*val dragthreshold = 30
        var downX = 0F
        var downY = 0F
        when(ev!!.action){

            MotionEvent.ACTION_DOWN -> {
                downX = ev.rawX
                downY = ev.rawY
            }

            MotionEvent.ACTION_MOVE -> {
                val disX = abs(ev.rawX - downX)
                val disY = abs(ev.rawY - downY)
                if (disY > disX && disY > dragthreshold){
                    this.parent.requestDisallowInterceptTouchEvent(false)
                    Home().getScrollView().requestDisallowInterceptTouchEvent(true)
                }else if(disX > disY && disX > dragthreshold){
                    this.parent.requestDisallowInterceptTouchEvent(true)
                    Home().getScrollView().requestDisallowInterceptTouchEvent(false)
                }
            }

            MotionEvent.ACTION_UP -> {
                this.parent.requestDisallowInterceptTouchEvent(false)
                Home().getScrollView().requestDisallowInterceptTouchEvent(false)
            }
        }*/
        return false
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        var height = 0
        for(i in 0 until childCount){
            val child : View = getChildAt(i)
            child.measure(widthMeasureSpec,View.MeasureSpec.makeMeasureSpec(0,MeasureSpec.UNSPECIFIED))

            val h = child.measuredHeight
            if (h > height){
                height = h
            }
        }

        val heightMeasureSpe = MeasureSpec.makeMeasureSpec(height,MeasureSpec.EXACTLY)
        super.onMeasure(widthMeasureSpec, heightMeasureSpe)

    }

    override fun onInterceptTouchEvent(ev: MotionEvent?): Boolean {
        return false
    }

}