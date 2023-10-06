package com.andre.guryanov.testgame.engine

import com.andre.guryanov.testgame.models.Monster
import com.andre.guryanov.testgame.models.Player

class CreatureConfigurator {



    fun createMario() : Player {
        return Player(MARIO, 10, 20, 100, 5..15, 4)
    }

    fun createGoomba() : Monster {
        return Monster(GOOMBA, 5, 15, 150, 1..15)
    }

    fun createBowser() : Monster {
        return Monster(BOWSER, 20, 10, 200, 10..20)
    }


    fun overrideCreature() {

    }

    fun overridePlayer(
        id: Int,
        attack: Int,
        defense: Int,
        maxHealth: Int,
        damage: IntRange,
        firstAidCount: Int
    ) : Player {
        return Player(id, attack, defense, maxHealth, damage, firstAidCount)
    }

    fun overrideMonster(
        id: Int,
        attack: Int,
        defense: Int,
        maxHealth: Int,
        damage: IntRange
    ) : Monster {
        return Monster(id, attack, defense, maxHealth, damage)
    }

//    fun createCustomCreature(
//        id: Int,
//        attack: Int,
//        defense: Int,
//        health: Int,
//        damage: IntRange
//    ) {
//
//    }

    companion object {
        const val MARIO = 0
        const val GOOMBA = 1
        const val BOWSER = 2
    }
}