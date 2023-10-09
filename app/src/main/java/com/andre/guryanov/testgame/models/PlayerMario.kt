package com.andre.guryanov.testgame.models

import android.widget.ImageView
import com.andre.guryanov.testgame.R
import com.andre.guryanov.testgame.engine.Animator
import com.andre.guryanov.testgame.engine.SoundPlayer
import com.andre.guryanov.testgame.engine.UiManager
import com.andre.guryanov.testgame.engine.modelData.MarioData
import kotlinx.coroutines.Job

class PlayerMario(
//    override val id: Int,
    override val attack: Int,
    override val defense: Int,
    override val maxHealth: Int,
    override val damage: IntRange,
    var firstAidCount: Int,
    override var health: Int = maxHealth,

) : Creature() {

    override val modelData: MarioData = MarioData()

    fun heal() : Boolean {
        if (firstAidCount < 1) return false
        firstAidCount--
        health += (maxHealth * 3 / 10)
        if (health > maxHealth) health = maxHealth
        return true
    }


    override fun getView(): ImageView {
        return UiManager.mario()
    }


    override fun animDefaultLoop() {//(callback: () -> Unit) {
        Animator.animateImage(UiManager.mario(), modelData.animDefault, true) {
//            callback()
        }
    }

    override fun animAttack(callback: () -> Unit) : Job {
        sfxAttack {  }
        return Animator.animateImage(UiManager.mario(), modelData.animAttack, false) {
            callback()
        }
    }

    override fun animDefense(callback: () -> Unit) : Job {
        sfxDefense {  }
        return Animator.animateImage(UiManager.mario(), modelData.animDefense, false) {
            callback()
        }
    }

    override fun animDamage(callback: () -> Unit) : Job {
        sfxDamage {  }
        return Animator.animateImage(UiManager.mario(), modelData.animDamage, false) {
            callback()
        }
    }

    override fun animWin(callback: () -> Unit) : Job {
        return Animator.animateImage(UiManager.mario(), modelData.animWin, false) {
            callback()
        }
    }

    override fun animWinLoop() {//(callback: () -> Unit) {

    }

    override fun animLose(callback: () -> Unit) : Job {
        sfxLose {  }
        return Animator.animateImage(UiManager.mario(), modelData.animLose, false) {
            callback()
        }
    }

    override fun animLoseLoop() {//(callback: () -> Unit) {
        Animator.animateImage(UiManager.mario(), modelData.animLoseLoop, true) {
            //callback()
        }
    }

    fun animAppearance(callback: () -> Unit) : Job {
        sfxAppearance {}
        return Animator.animateImage(UiManager.mario(), modelData.animAppearance, false, 200L) {
            callback()
        }

    }

    fun animHeal(callback: () -> Unit) : Job {
        sfxHeal {}
        return Animator.animateImage(UiManager.mario(), modelData.animHeal, false) {
            callback()
        }

    }

    fun animWinShots() : Job {
        sfxAttack {  }
        return Animator.animateImage(UiManager.mario(), modelData.animWinLoop, false, 150L) {  }
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

    fun sfxWin(callback: () -> Unit) {
        SoundPlayer.playSFX(UiManager.context(), modelData.sfxWin) {
            callback()
        }
    }

    fun sfxHeal(callback: () -> Unit){
        SoundPlayer.playSFX(UiManager.context(), modelData.sfxHeal, Animator.animFreq) {
            callback()
        }
    }

    fun sfxAppearance(callback: () -> Unit) {
        SoundPlayer.playSFX(UiManager.context(), modelData.sfxAppearance) {
            callback()
        }
    }

}
