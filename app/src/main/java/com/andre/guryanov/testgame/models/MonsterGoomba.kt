package com.andre.guryanov.testgame.models

import android.widget.ImageView
import com.andre.guryanov.testgame.engine.Animator
import com.andre.guryanov.testgame.engine.SoundPlayer
import com.andre.guryanov.testgame.engine.UiManager
import com.andre.guryanov.testgame.engine.modelData.GoombaData
import kotlinx.coroutines.Job

class MonsterGoomba(
//    override val id: Int,
    override val attack: Int,
    override val defense: Int,
    override val maxHealth: Int,
    override val damage: IntRange,
    override var health: Int = maxHealth
) : Creature() {

    override val modelData: GoombaData = GoombaData()


    override fun getView(): ImageView {
        return UiManager.goomba()
    }


    override fun animDefaultLoop() {//(callback: () -> Unit) {
        Animator.animateImage(UiManager.goomba(), modelData.animDefault, true) {
//            callback()
        }
    }

    override fun animAttack(callback: () -> Unit) : Job {
        sfxAttack {  }
        return Animator.animateImage(UiManager.goomba(), modelData.animAttack, false) {
            callback()
        }
    }

    override fun animDefense(callback: () -> Unit) : Job {
        sfxDefense {  }
        return Animator.animateImage(UiManager.goomba(), modelData.animDefense, false) {
            callback()
        }

    }

    override fun animDamage(callback: () -> Unit) : Job {
        sfxDamage {  }
        return Animator.animateImage(UiManager.goomba(), modelData.animDamage, false) {
            callback()
        }
    }

    override fun animWin(callback: () -> Unit) : Job {
        return Animator.animateImage(UiManager.goomba(), modelData.animWin, false) {
            callback()
        }
    }

    override fun animWinLoop() {//(callback: () -> Unit) {
        Animator.animateImage(UiManager.goomba(), modelData.animWinLoop, true) {
            //callback()
        }
    }

    override fun animLose(callback: () -> Unit) : Job {
        sfxLose {  }
        return Animator.animateImage(UiManager.goomba(), modelData.animLose, false) {
            callback()
        }
    }

    override fun animLoseLoop() {//(callback: () -> Unit) {

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
        SoundPlayer.playSFX(UiManager.context(), modelData.sfxLose, Animator.animFreq * 3) {
            callback()
        }
    }

}
