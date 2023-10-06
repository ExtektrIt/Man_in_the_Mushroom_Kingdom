package com.andre.guryanov.testgame.models

class Player(
    override val id: Int,
    override val attack: Int,
    override val defense: Int,
    override val maxHealth: Int,
    override val damage: IntRange,
    override var health: Int = maxHealth,
    var firstAidCount: Int = 4
) : Creature() {



//    fun heal() : Boolean {
//        if (firstAidCount < 1) return false
//        firstAidCount--
//        health += (maxHealth * 3 / 10)
//        return true
//    }

}
