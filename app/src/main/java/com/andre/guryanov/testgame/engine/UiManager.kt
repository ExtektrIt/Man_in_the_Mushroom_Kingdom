package com.andre.guryanov.testgame.engine

import android.content.Context
import android.graphics.Color
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.andre.guryanov.testgame.R
import com.andre.guryanov.testgame.ui.MainActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

object UiManager {

    private lateinit var activity: MainActivity
    private lateinit var controller: Controller
//    private val anim: Animator = Animator

    fun init(main: MainActivity) {
        activity = main
    }

    fun setController(controller: Controller) {
        this.controller = controller
    }


    fun context() : Context {
        return activity
    }

//    fun animation() : AnimationPlayer {
//        return anim
//    }

//    fun animateObject(obj: ImageView, list: Array<Int>, loop: Boolean, freq: Long = anim.animFreq,
//                     callback: () -> Unit) {
//        anim.animateImage(obj, list, loop, freq) {
//            callback()
//        }
//    }

    fun openOptions() {
        activity.openOptions()
    }

    fun closeOptions() {
        activity.closeOptions()
    }

    fun background() : ImageView {
        return activity.getBG()
    }

    fun mario() : ImageView {
        return activity.getMarioPH()
    }

    fun goomba() : ImageView {
        return activity.getGoombaPH()
    }

    fun bowser() : ImageView {
        return activity.getBowserPH()
    }

    fun playerHealth() : TextView {
        return activity.getPlayerHealth()
    }

    fun monsterHealth() : TextView {
        return activity.getMonsterHealth()
    }

    fun firstAid() : TextView {
        return activity.getFirstAid()
    }

    fun livesGroup() : ConstraintLayout {
        return activity.getLivesGroup()
    }

    fun message() : TextView {
        return activity.getMessage()
    }

//    fun animateMario(list: ArrayList<Int>, loop: Boolean, freq: Long = anim.animFreq,
//                     callback: () -> Unit) {
//        anim.animateImage(activity.getMarioPH(), 0, list, loop, freq) {
//            callback()
//        }
//    }
//
//    fun animateGoomba(list: ArrayList<Int>, loop: Boolean, freq: Long = anim.animFreq,
//                      callback: () -> Unit) {
//        anim.animateImage(activity.getGoombaPH(), 0, list, loop, freq) {
//            callback()
//        }
//    }
//
//    fun animateBowser(list: ArrayList<Int>, loop: Boolean, freq: Long = anim.animFreq,
//                      callback: () -> Unit) {
//        anim.animateImage(activity.getBowserPH(), 0, list, loop, freq) {
//            callback()
//        }
//    }

    suspend fun startScreenDimming(freq: Long, callback: () -> Unit) {
        val str = arrayOf('A', 'B', 'C', 'D', 'E', 'F')
        for (i in 0..15) {
            val color =
                if (i < 10) "#${i}F000000"
                else "#${str[i - 10]}F000000"
            withContext(Dispatchers.Main) {
                activity.getBlackout().setBackgroundColor(Color.parseColor(color))
                activity.getBlackout().invalidate()
            }
            delay(freq)
        }
        callback()
    }

    suspend fun startScreenBrightening(freq: Long, callback: () -> Unit) {
        val str = arrayOf('A', 'B', 'C', 'D', 'E', 'F')
        for (i in 15 downTo 0) {
            val color =
                if (i < 10) "#${i}0000000"
                else "#${str[i - 10]}0000000"
            withContext(Dispatchers.Main) {
                activity.getBlackout().setBackgroundColor(Color.parseColor(color))
                activity.getBlackout().invalidate()
            }
            delay(freq)
        }
        callback()
    }

    fun dimScreen() {
        activity.getBlackout().setBackgroundColor(Color.parseColor("#AA000000"))
        activity.getBlackout().invalidate()
    }

    fun restoreScreenBrightness() {
        activity.getBlackout().setBackgroundColor(Color.parseColor("#00000000"))
        activity.getBlackout().invalidate()
    }

    fun invisibleAllViews() {
        val invis = View.INVISIBLE
        activity.getMarioPH().visibility = invis
        activity.getGoombaPH().visibility = invis
        activity.getBowserPH().visibility = invis
        livesGroup().visibility = invis
        message().visibility = invis
    }

    fun selectLevel(level: Int) {
        activity.selectLevel(level)
    }

}