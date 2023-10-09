package com.andre.guryanov.testgame.engine.levels

import android.view.View
import com.andre.guryanov.testgame.R
import com.andre.guryanov.testgame.engine.Animator
import com.andre.guryanov.testgame.engine.CreatureConfigurator
import com.andre.guryanov.testgame.engine.Game
import com.andre.guryanov.testgame.engine.UiManager
import com.andre.guryanov.testgame.models.MonsterBowser
import com.andre.guryanov.testgame.models.MonsterGoomba

class LevelBowser : Level() {
    override val enemy: MonsterBowser = CreatureConfigurator.createBowser()
    override val bgSound: Int = R.raw.shnyaga_5_1_0
    override val bgImages: Array<Int> = arrayOf(
        R.drawable.bg_bowser_2
    )


    override fun prepareLevel() {
        val ui = UiManager
        ui.background().setImageResource(bgImages[0])
        ui.mario().setImageResource(R.drawable.empty)
        ui.mario().visibility = View.VISIBLE
        ui.bowser().visibility = View.VISIBLE
        ui.livesGroup().visibility = View.VISIBLE
        Game.refreshHealth()
        Animator.animateImage(ui.bowser(), enemy.modelData.animDefault, true) {}
    }

    override fun launchLevel() {
        Game.startDancing()
    }
}