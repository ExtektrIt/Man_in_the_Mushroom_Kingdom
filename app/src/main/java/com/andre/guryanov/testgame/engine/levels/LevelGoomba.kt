package com.andre.guryanov.testgame.engine.levels

import android.view.View
import com.andre.guryanov.testgame.R
import com.andre.guryanov.testgame.engine.Animator
import com.andre.guryanov.testgame.engine.CreatureConfigurator
import com.andre.guryanov.testgame.engine.Game
import com.andre.guryanov.testgame.engine.UiManager
import com.andre.guryanov.testgame.models.MonsterGoomba

class LevelGoomba : Level() {
    override val enemy: MonsterGoomba = CreatureConfigurator.createGoomba()
    override val bgSound: Int = R.raw.veslo_3_4_0_loop_t
    override val bgImages: Array<Int> = arrayOf(
        R.drawable.bg_goomba_2
    )


    override fun prepareLevel() {
        val ui = UiManager
        Game.setMario(CreatureConfigurator.createMario())

        ui.background().setImageResource(bgImages[0])
        ui.mario().setImageResource(R.drawable.empty)
        ui.mario().visibility = View.VISIBLE
        ui.goomba().visibility = View.VISIBLE
        ui.livesGroup().visibility = View.VISIBLE
        Game.refreshHealth()
        Animator.animateImage(ui.goomba(), enemy.modelData.animDefault, true) {}
    }

    override fun launchLevel() {
        Game.startDancing()

    }
}