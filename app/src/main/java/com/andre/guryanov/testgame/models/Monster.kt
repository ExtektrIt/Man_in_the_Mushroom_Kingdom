package com.andre.guryanov.testgame.models

class Monster(
    override val id: Int,
    override val attack: Int,
    override val defense: Int,
    override val maxHealth: Int,
    override val damage: IntRange,
    override var health: Int = maxHealth
) : Creature() {

}
