package com.andre.guryanov.testgame.models

import com.andre.guryanov.testgame.engine.Game

abstract class Creature {
    abstract val id: Int
    abstract val attack: Int
    abstract val defense: Int
    abstract val maxHealth: Int
    abstract val damage: IntRange
    abstract var health: Int


//    fun attack(victim: Creature) : Boolean {
//        var attackModifier = attack - (victim.defense + 1)
//        if (attackModifier < 1) attackModifier = 1
//        calculateAttackSuccess(attackModifier)
//    }
//
//    private fun calculateAttackSuccess(modifier: Int) : Boolean {
//        var i = 0
////        var success = false
//        while (i < modifier) {
//            val diceFace =
//            if (Game.rollTheDice())
//            i++
//        }
//    }

//    private fun computeAttack(modifier: Int) : Boolean {
//        var i = 0
//        while (i < modifier) {
//            val rand =
//            i++
//        }
//    }

}