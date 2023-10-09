package com.andre.guryanov.testgame.models

import android.widget.ImageView
import com.andre.guryanov.testgame.engine.Animator
import com.andre.guryanov.testgame.engine.SoundPlayer
import com.andre.guryanov.testgame.engine.UiManager
import com.andre.guryanov.testgame.engine.modelData.BowserData
import kotlinx.coroutines.Job

class MonsterBowser(
    override val attack: Int,
    override val defense: Int,
    override val maxHealth: Int,
    override val damage: IntRange,
    override var health: Int = maxHealth
    ): Creature() {

    override val modelData: BowserData = BowserData()


    override fun getView(): ImageView {
        return UiManager.bowser()
    }


    override fun animDefaultLoop() {
        Animator.animateImage(UiManager.bowser(), modelData.animDefault, true) {
        }
    }

    override fun animAttack(callback: () -> Unit) : Job {
        val attack =
            if ((1..4).random() == 4) modelData.animAttack2
            else modelData.animAttack
        sfxAttack {  }
        return Animator.animateImage(UiManager.bowser(), attack, false) {
            callback()
        }
    }

    override fun animDefense(callback: () -> Unit) : Job {
        sfxDefense {  }
        return Animator.animateImage(UiManager.bowser(), modelData.animDefense, false) {
            callback()
        }
    }

    override fun animDamage(callback: () -> Unit) : Job {
        sfxDamage {  }
        return Animator.animateImage(UiManager.bowser(), modelData.animDamage, false) {
            callback()
        }
    }

    override fun animWin(callback: () -> Unit) : Job {
        return Animator.animateImage(UiManager.bowser(), modelData.animWin, false) {
            callback()
        }
    }

    override fun animWinLoop() {
        Animator.animateImage(UiManager.bowser(), modelData.animWinLoop, true) {
        }
    }

    override fun animLose(callback: () -> Unit) : Job {
        sfxLose {  }
        return Animator.animateImage(UiManager.bowser(), modelData.animLose, false) {
            callback()
        }
    }

    override fun animLoseLoop() {
        Animator.animateImage(UiManager.bowser(), modelData.animLoseLoop, true) {
        }
    }

    // Звуковые эффекты

    override fun sfxAttack(callback: () -> Unit) {
        SoundPlayer.playSFX(UiManager.context(), modelData.sfxAttack) {
            callback()
        }
    }

    override fun sfxDefense(callback: () -> Unit) {
        SoundPlayer.playSFX(UiManager.context(), modelData.sfxDefense) {
            callback()
        }
    }

    override fun sfxDamage(callback: () -> Unit) {
        SoundPlayer.playSFX(UiManager.context(), modelData.sfxDamage) {
            callback()
        }
    }

    override fun sfxLose(callback: () -> Unit) {
        SoundPlayer.playSFX(UiManager.context(), modelData.sfxLose) {
            callback()
        }
    }
}