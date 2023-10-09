package com.andre.guryanov.testgame.engine

interface Controller {

    fun bindController() {
        Game.controller = this
    }

    fun lockActionButtons()

    fun unlockActionButtons()
}