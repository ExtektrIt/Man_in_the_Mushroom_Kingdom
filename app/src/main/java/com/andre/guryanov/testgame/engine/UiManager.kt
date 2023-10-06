package com.andre.guryanov.testgame.engine

import android.content.Context
import android.graphics.Color
import android.view.View
import com.andre.guryanov.testgame.*
import com.andre.guryanov.testgame.engine.animModels.Background
import com.andre.guryanov.testgame.engine.animModels.Bowser
import com.andre.guryanov.testgame.engine.animModels.Goomba
import com.andre.guryanov.testgame.engine.animModels.Mario
import com.andre.guryanov.testgame.ui.MainActivity
import kotlinx.coroutines.delay

class UiManager {

    private lateinit var activity: MainActivity
    private val anim: AnimationCreator = AnimationCreator()

    fun init(main: MainActivity) {
        activity = main
    }

    fun context() : Context {
        return activity
    }

//    fun animation() : AnimationPlayer {
//        return anim
//    }

    fun animateMario(list: ArrayList<Int>, loop: Boolean, freq: Long = anim.animFreq,
                     callback: () -> Unit) {
        anim.animateImage(activity.getMarioPH(), 0, list, loop, freq) {
            callback()
        }
    }

    fun animateGoomba(list: ArrayList<Int>, loop: Boolean, freq: Long = anim.animFreq,
                      callback: () -> Unit) {
        anim.animateImage(activity.getGoombaPH(), 0, list, loop, freq) {
            callback()
        }
    }

    fun animateBowser(list: ArrayList<Int>, loop: Boolean, freq: Long = anim.animFreq,
                      callback: () -> Unit) {
        anim.animateImage(activity.getBowserPH(), 0, list, loop, freq) {
            callback()
        }
    }

    suspend fun startScreenDimming(freq: Long, callback: (ui: UiManager) -> Unit) {
        val str = arrayOf('A', 'B', 'C', 'D', 'E', 'F')
        for (i in 0..15) {
            val color = if (i < 10) "#$i${i}000000"
            else "#${str[i - 10]}${str[i - 10]}000000"
            activity.getBlackout().setBackgroundColor(Color.parseColor(color))
            delay(freq)
        }
        callback(this@UiManager)

//        CoroutineScope(Dispatchers.Main).launch {
//            for (i in 0..15) {
//                val color = if (i < 10) "#$i${i}000000"
//                else "#${str[i - 10]}${str[i - 10]}000000"
//                activity.getBlackout().setBackgroundColor(Color.parseColor(color))
//                delay(freq)
//            }
//            callback(this@UiManager)
//        }
    }

    suspend fun startScreenBrightening(freq: Long, callback: (ui: UiManager) -> Unit) {
        val str = arrayOf('A', 'B', 'C', 'D', 'E', 'F')
        for (i in 15 downTo 0) {
            val color = if (i < 10) "#$i${i}000000"
            else "#${str[i - 10]}${str[i - 10]}000000"
            activity.getBlackout().setBackgroundColor(Color.parseColor(color))
            delay(freq)
        }
        callback(this@UiManager)

//        CoroutineScope(Dispatchers.Main).launch {
////            for (i in 15 downTo 0) {
////                val color = if (i < 10) "#$i${i}000000"
////                else "#${str[i - 10]}${str[i - 10]}}000000"
////                activity.getBlackout().setBackgroundColor(Color.parseColor(color))
////                delay(freq)
////            }
////            callback(this@UiManager)
//        }
    }

    fun dimScreen50() {
        activity.getBlackout().setBackgroundColor(Color.parseColor("#AA000000"))
        activity.getBlackout().invalidate()
    }

    fun restoreScreenBrightness() {
        activity.getBlackout().setBackgroundColor(Color.parseColor("#00000000"))
        activity.getBlackout().invalidate()
    }

    fun prepareLevel(level: Int) {
        invisibleAllViews()
        anim.stopAllAnim()
        when (level) {
            0 -> {
                anim.animateImage(activity.getBG(), 0, Background.getImages(), true, 2000) {}
//                activity.getBG().setImageResource(R.drawable.bg_1_m)
            }
            1 -> {
                activity.getBG().setImageResource(R.drawable.bg_goomba_test)
                activity.getMarioPH().visibility = View.VISIBLE
                activity.getMarioPH().setImageResource(R.drawable.empty)
                activity.getGoombaPH().visibility = View.VISIBLE
                anim.animateImage(activity.getGoombaPH(), 1, Goomba.default(), true) {}
            }
            2 -> {
                activity.getBG().setImageResource(R.drawable.bg2_test)
                activity.getMarioPH().visibility = View.VISIBLE
                activity.getMarioPH().setImageResource(R.drawable.empty)
                activity.getBowserPH().visibility = View.VISIBLE
                anim.animateImage(activity.getBowserPH(), 2, Bowser.default(), true) {}
            }
            3 -> {

            }
//            else -> return
        }
    }

    fun launchLevel(level: Int) {
        when(level) {
            1, 2 -> {
                anim.animateImage(activity.getMarioPH(), 0, Mario.appearance(), false, 200) {
                    anim.animateImage(activity.getMarioPH(), 0, Mario.default(), true, 300) {

                        Game.startDancing()
                    }
                }
                activity.selectLevel(level)
////                anim.animateImage(activity.getGoombaPH(), 1, Goomba().default(), true) {}
            }
//            2 -> anim.animateImage(activity.getBowserPH(), 2, Bowser().default(), true) {}
        }
    }

    fun invisibleAllViews() {
        val invis = View.INVISIBLE
        activity.getMarioPH().visibility = invis
        activity.getGoombaPH().visibility = invis
        activity.getBowserPH().visibility = invis
//        activity.getBG().visibility = invis
    }

    fun lockButtons() {

    }

    fun unlockButtons() {

    }

//    fun changeImageBrightness(image: ImageView, freq: Long) {
//        CoroutineScope(Dispatchers.Main).launch {
//            val s = arrayOf('A', 'B', 'C', 'D', 'E', 'F')
//            for (i in 1..16) {
//                val color = if (i < 10) "$i{$i}000000"
//                else "${}${}000000"
//            }
//            activity.getBlackout().setBackgroundColor()
//        }
//    }

//    fun selectLevel(level: Int) {
////        activity.selectLevel(level)
//        val dest = when(level){
//            1 -> R.id.nav_goomba
//            2 -> R.id.nav_bowser
//            0 -> R.id.nav_title
//            else -> R.id.nav_congrats
//        }
//        activity.navController.navigate(dest)
//    }

//    fun startActionOnFragment(level: Int, action: () -> Unit) {
//        when(level) {
//            0 -> currentFrag as TitleFragment
//            1 -> currentFrag as BattleGoombaFragment
//            2 -> currentFrag as BattleBowserFragment
//            3 -> currentFrag as CongratulationsFragment
//            else -> return
//        }
//        action()
//    }

//    fun t() {
//        startActionOnFragment(1) {
//            currentFrag
//        }
//        activity
//    }

    fun stopAnim() {
        anim.stopAllAnim()
    }

}