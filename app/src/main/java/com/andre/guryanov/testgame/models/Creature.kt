package com.andre.guryanov.testgame.models

import android.widget.ImageView
import com.andre.guryanov.testgame.engine.*
import com.andre.guryanov.testgame.engine.modelData.ModelData
import kotlinx.coroutines.Job

abstract class Creature {

    abstract val attack: Int
    abstract val defense: Int
    abstract val maxHealth: Int
    abstract val damage: IntRange
    abstract var health: Int

    abstract val modelData: ModelData

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

    abstract fun animDefaultLoop()
    abstract fun animAttack(callback: () -> Unit) : Job
    abstract fun animDefense(callback: () -> Unit) : Job
    abstract fun animDamage(callback: () -> Unit) : Job
    abstract fun animWin(callback: () -> Unit) : Job
    abstract fun animWinLoop()
    abstract fun animLose(callback: () -> Unit) : Job
    abstract fun animLoseLoop()


    abstract fun sfxAttack(callback: () -> Unit)
    abstract fun sfxDefense(callback: () -> Unit)
    abstract fun sfxDamage(callback: () -> Unit)
    abstract fun sfxLose(callback: () -> Unit)

}