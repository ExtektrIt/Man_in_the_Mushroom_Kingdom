package com.andre.guryanov.testgame.engine.modelData

abstract class ModelData {

    abstract val sfxAttack: Int
    abstract val sfxDefense: Int
    abstract val sfxDamage: Int
    abstract val sfxLose: Int

    abstract val animDefault: Array<Int>
    abstract val animAttack: Array<Int>
    abstract val animDefense: Array<Int>
    abstract val animDamage: Array<Int>
    abstract val animWin: Array<Int>
    abstract val animWinLoop: Array<Int>
    abstract val animLose: Array<Int>
    abstract val animLoseLoop: Array<Int>

}