package com.andre.guryanov.testgame.engine.levels

import com.andre.guryanov.testgame.models.Monster

abstract class Level {

    abstract val enemy: Monster
    abstract val bg: Array<Int>
//    abstract val

//    abstract fun init()

    abstract fun prepareLevel()

    abstract fun launchLevel()



    companion object {

        var level = 0


    }
}