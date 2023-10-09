package com.andre.guryanov.testgame.engine

import com.andre.guryanov.testgame.R
import com.andre.guryanov.testgame.models.MonsterBowser
import com.andre.guryanov.testgame.models.MonsterGoomba
import com.andre.guryanov.testgame.models.PlayerMario

object CreatureConfigurator {

    var mario: PlayerMario? = null
    var goomba: MonsterGoomba? = null
    var bowser: MonsterBowser? = null

    fun createMario() : PlayerMario {
        return mario ?: PlayerMario(10, 20, 100, 500..510, 4)
    }

    fun createGoomba() : MonsterGoomba {
        return goomba ?: MonsterGoomba(5, 15, 150, 1..150)
    }

    fun createBowser() : MonsterBowser {
        return bowser ?: MonsterBowser(20, 10, 200, 10..200)
    }

//
//    private fun checkOverriding(attack: Int, defense: Int, maxHealth: Int, damage: IntRange) : Boolean {
//        return ((attack in 1..30)
//                && (defense in 1..30)
//                && (maxHealth in 1..1000)
//                && (damage.first in 0..1000)
//                && (damage.last in damage.first..1000))
//
//    }
    fun restoreAllHealth() {
        if (mario != null) mario!!.health = mario!!.maxHealth
        if (goomba != null) goomba!!.health = goomba!!.maxHealth
        if (bowser != null) bowser!!.health = bowser!!.maxHealth

    }

    fun overrideCreature(id: Int, attack: Int, defense: Int, maxHealth: Int, damage: IntRange, aid: Int) : Boolean {
        if ((attack in 1..30)
            && (defense in 1..30)
            && (maxHealth in 1..1000)
            && (damage.first in 0..1000)
            && (damage.last in damage.first..1000)
            && (aid in 0..4))
        {
            when (id) {
                R.string.override_mario -> overrideMario(attack, defense, maxHealth, damage, aid) //PlayerMario(attack, defense, maxHealth, damage, aid)
                R.string.override_goomba -> overrideGoomba(attack, defense, maxHealth, damage) //MonsterGoomba(attack, defense, maxHealth, damage)
                R.string.override_bowser -> overrideBowser(attack, defense, maxHealth, damage) //MonsterBowser(attack, defense, maxHealth, damage)
            }
            return true
        }
        else return false
    }

    fun overrideMario(
        attack: Int,
        defense: Int,
        maxHealth: Int,
        damage: IntRange,
        firstAidCount: Int
    ) {
        mario = PlayerMario(attack, defense, maxHealth, damage, firstAidCount)
    }

    fun overrideGoomba(
        attack: Int,
        defense: Int,
        maxHealth: Int,
        damage: IntRange
    ) {
        goomba = MonsterGoomba(attack, defense, maxHealth, damage)
    }

    fun overrideBowser(
        attack: Int,
        defense: Int,
        maxHealth: Int,
        damage: IntRange
    ) {
        bowser = MonsterBowser(attack, defense, maxHealth, damage)
    }



//    fun overrideMario(
//        attack: Int,
//        defense: Int,
//        maxHealth: Int,
//        damage: IntRange,
//        firstAidCount: Int
//    ) : Boolean {
//        if (firstAidCount !in 0..4) return false
//        val check = checkOverriding(attack, defense, maxHealth, damage)
//        if (check) mario = PlayerMario(attack, defense, maxHealth, damage, firstAidCount)
//        return check
//    }
//
//    fun overrideGoomba(
//        attack: Int,
//        defense: Int,
//        maxHealth: Int,
//        damage: IntRange
//    ) : Boolean {
//        val check = checkOverriding(attack, defense, maxHealth, damage)
//        if (check) goomba = MonsterGoomba(attack, defense, maxHealth, damage)
//        return check
//    }
//
//    fun overrideBowser(
//        attack: Int,
//        defense: Int,
//        maxHealth: Int,
//        damage: IntRange
//    ) : Boolean {
//        val check = checkOverriding(attack, defense, maxHealth, damage)
//        if (check) bowser = MonsterBowser(attack, defense, maxHealth, damage)
//        return check
//    }

}