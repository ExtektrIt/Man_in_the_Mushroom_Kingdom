package com.andre.guryanov.testgame.engine.levels

import android.view.View
import com.andre.guryanov.testgame.R
import com.andre.guryanov.testgame.engine.CreatureConfigurator
import com.andre.guryanov.testgame.engine.Game
import com.andre.guryanov.testgame.engine.UiManager
import com.andre.guryanov.testgame.models.MonsterGoomba

class Congrats : Level() {
    override val enemy: MonsterGoomba? = null
    override val bgSound: Int = R.raw.chillyatina_2_3_t
    override val bgImages: Array<Int> = arrayOf(
        R.drawable.bg_3
    )


    override fun prepareLevel() {
        UiManager.background().setImageResource(bgImages[0])
        UiManager.message().text = UiManager.context().getString(R.string.congrats)
        UiManager.message().visibility = View.VISIBLE
    }

    override fun launchLevel() {

    }
}