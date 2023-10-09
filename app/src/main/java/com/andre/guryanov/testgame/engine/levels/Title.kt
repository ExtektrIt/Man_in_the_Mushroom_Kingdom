package com.andre.guryanov.testgame.engine.levels

import android.view.View
import com.andre.guryanov.testgame.R
import com.andre.guryanov.testgame.engine.*
import com.andre.guryanov.testgame.models.MonsterGoomba

class Title : Level() {

    override val enemy: MonsterGoomba? = null
    override val bgSound: Int = R.raw.nine9999_in_1_3_0
    override val bgImages: Array<Int> = arrayOf(
            R.drawable.bg_1_m,
            R.drawable.bg_2_m,
            R.drawable.bg_3_m,
            R.drawable.bg_4_d,
            R.drawable.bg_5_d,
            R.drawable.bg_6_d,
            R.drawable.bg_7_e,
            R.drawable.bg_8_e,
            R.drawable.bg_9_e,
            R.drawable.bg_10_e,
            R.drawable.bg_11_n,
            R.drawable.bg_12_n,
            R.drawable.bg_13_n,
            R.drawable.bg_0_m,
        )


    override fun prepareLevel() {
        Animator.animateImage(UiManager.background(), bgImages, true, 2_000L) {}
        UiManager.message().text = UiManager.context().getString(R.string.game)
        UiManager.message().visibility = View.VISIBLE
        CreatureConfigurator.restoreAllHealth()
    }

    override fun launchLevel() {

    }
}