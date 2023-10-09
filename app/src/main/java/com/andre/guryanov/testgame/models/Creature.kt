package com.andre.guryanov.testgame.models

import android.widget.ImageView
import com.andre.guryanov.testgame.engine.*
import com.andre.guryanov.testgame.engine.modelData.ModelData
import kotlinx.coroutines.Job

abstract class Creature {
//    abstract val id: Int
    abstract val attack: Int
    abstract val defense: Int
    abstract val maxHealth: Int
    abstract val damage: IntRange
    abstract var health: Int

    abstract val modelData: ModelData
//    var turnOwner = false

    fun attack(victim: Creature) : Boolean {
        var modifier = attack - (victim.defense + 1)
        if (modifier < 1) modifier = 1
        var i = 0
        while (i < modifier) {
            if (rollTheDice() in Settings.successfulAttack) {
                victim.health-= damage.random()
                if (victim.health < 0 ) victim.health = 0
                return true
            }
            i++
        }
        return false
    }

    fun staysAlive() : Boolean {
        return health > 0
    }

    private fun rollTheDice() : Int {
        return (1..Settings.diceFaces).random()
    }

    abstract fun getView() : ImageView

    abstract fun animDefaultLoop()//(callback: () -> Unit)
    abstract fun animAttack(callback: () -> Unit) : Job
    abstract fun animDefense(callback: () -> Unit) : Job
    abstract fun animDamage(callback: () -> Unit) : Job
    abstract fun animWin(callback: () -> Unit) : Job
    abstract fun animWinLoop()//(callback: () -> Unit)
    abstract fun animLose(callback: () -> Unit) : Job
    abstract fun animLoseLoop()//(callback: () -> Unit)


    abstract fun sfxAttack(callback: () -> Unit)
    abstract fun sfxDefense(callback: () -> Unit)
    abstract fun sfxDamage(callback: () -> Unit)
//    abstract fun sfxWin(callback: () -> Unit)
    abstract fun sfxLose(callback: () -> Unit)


//    fun animDefault(callback: () -> Unit) {
//        Animator.animateImage(UiManager.goomba(), modelData.animDefault, true) {
//            callback()
//        }
//    }
//    fun animAttack(callback: () -> Unit) {
//        Animator.animateImage(UiManager.goomba(), modelData.animAttack, true) {
//            callback()
//        }
//    }
//    fun animDefense(callback: () -> Unit) {
//        Animator.animateImage(UiManager.goomba(), modelData.animDefense, true) {
//            callback()
//        }
//    }
//    fun animDamage(callback: () -> Unit) {
//        Animator.animateImage(UiManager.goomba(), modelData.animDamage, true) {
//            callback()
//        }
//    }
//    fun animWin(callback: () -> Unit) {
//        Animator.animateImage(UiManager.goomba(), modelData.animWin, true) {
//            callback()
//        }
//    }
//    fun animWinLoop(callback: () -> Unit) {
//        Animator.animateImage(UiManager.goomba(), modelData.animWinLoop, true) {
//            callback()
//        }
//    }
//    fun animLose(callback: () -> Unit) {
//        Animator.animateImage(UiManager.goomba(), modelData.animLose, true) {
//            callback()
//        }
//    }
//    fun animLoseLoop(callback: () -> Unit) {
//        Animator.animateImage(UiManager.goomba(), modelData.animLoseLoop, true) {
//            callback()
//        }
//    }
//
//
//    fun sfxAttack(callback: () -> Unit) {
//        SoundPlayer.playSFX(UiManager.context(), modelData.sfxAttack) {
//            callback()
//        }
//    }
//
//    fun sfxDefense(callback: () -> Unit) {
//        SoundPlayer.playSFX(UiManager.context(), modelData.sfxDefense) {
//            callback()
//        }
//    }
//
//    fun sfxDamage(callback: () -> Unit) {
//        SoundPlayer.playSFX(UiManager.context(), modelData.sfxDamage) {
//            callback()
//        }
//    }
//
//    fun sfxLose(callback: () -> Unit) {
//        SoundPlayer.playSFX(UiManager.context(), modelData.sfxLose) {
//            callback()
//        }
//    }

    companion object {
//        const val MARIO_ID = 0
//        const val GOOMBA_ID = 1
//        const val BOWSER_ID = 2

    }

}