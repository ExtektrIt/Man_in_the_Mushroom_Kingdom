package com.andre.guryanov.testgame.engine

import com.andre.guryanov.testgame.engine.animModels.Bowser
import com.andre.guryanov.testgame.engine.animModels.Goomba
import com.andre.guryanov.testgame.engine.animModels.Mario
import com.andre.guryanov.testgame.models.Creature
import com.andre.guryanov.testgame.models.Monster
import com.andre.guryanov.testgame.models.Player
import com.andre.guryanov.testgame.ui.MainActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

object Game {
    const val MARIO_ID = 0
    const val GOOMBA_ID = 1
    const val BOWSER_ID = 2
    const val BG_ID = 2

    private var ui = UiManager()//: MainActivity? = null
    private val soundPlayer = SoundPlayer()
    private val settings = Settings()

    private var mario: Player = Player(MARIO_ID, 10, 20, 100, 50..60)
    private var goomba: Monster = Monster(GOOMBA_ID, 5, 15, 150, 1..15)
    private var bowser: Monster = Monster(BOWSER_ID, 20, 10, 200, 10..20)

    private var turnOwner: Creature = mario//Int = MARIO_ID
    private var level: Int = 0
    private var gameIsPlaying = false


    fun launchGame() {//context: Context) {
//        soundPlayer.playMusic(context.resources.assets(R.raw.nine9999_in_1_3_0))//(R.raw.nine9999_in_1_3_0))
//        soundPlayer.playMusic(context, R.raw.nine9999_in_1_3_0)
//        soundPlayer.playMusic(ui!!, level)//R.raw.nine9999_in_1_3_0)
        ui.prepareLevel(level)
        soundPlayer.playMusic(ui.context(), level)//R.raw.nine9999_in_1_3_0)
        //запуск музыки
        //запуск анимации картинок
    }

    fun setUI(activity: MainActivity) {
//        ui = activity
        ui.init(activity)
    }

    fun start() {
        level++
//        if (level == 4) level = 0 // убрать, для ранних тестов плеера
//        selectLevel()
        soundPlayer.playMusic(ui.context(), level)

        CoroutineScope(Dispatchers.Main).launch {
            ui.startScreenDimming(120){}
            ui.prepareLevel(level)
//            ui.restoreScreenBrightness()
            ui.startScreenBrightening(120){}
            ui.launchLevel(level)
        }
//        soundPlayer.playMusic(ui.context(), level)
//        ui.startScreenDimming(120L) {
//            ui.showScreen(level)
//            ui.startScreenBrightening(120L) {
//
//            }
//        }


    }

    fun startDancing() {

    }

    fun backToTitle() {
        level = 0
        selectLevel()
    }

    fun pause() {
        soundPlayer.pause()
    }

    fun resume() {
        soundPlayer.resume()
    }

    fun load() {

    }

    fun save() {

    }

    fun restartLevel() {

    }

    fun overrideCreature(
        id: Int,
        attack: Int,
        defense: Int,
        maxHealth: Int,
        damage: IntRange,
        firstAidCount: Int?
    ) {
        when (id) {
            MARIO_ID -> mario = Player(id, attack, defense, maxHealth, damage, firstAidCount!!)
            GOOMBA_ID -> goomba = Monster(id, attack, defense, maxHealth, damage)
            BOWSER_ID -> bowser = Monster(id, attack, defense, maxHealth, damage)
        }
    }

    fun attack() {
        var successAttack: Boolean
        var finishRound = false
        val victim = getOpponent()
        var modifier = turnOwner.attack - (victim.defense + 1)
        if (modifier < 1) modifier = 1
        successAttack = attackSuccess(modifier)
        if (successAttack) {
            val dmg = turnOwner.damage.random()
            if (victim.health > dmg) victim.health -= dmg
            else {
                victim.health = 0
                finishRound = true//finishRound()
            }
        }
//        else {
//            opponentInDefense(victim)
//            switchTurnOwner()
//        }
        completeTurn(successAttack, finishRound)

    }

    fun healPlayer() : Boolean = with(getPlayer()) {
        if (firstAidCount < 1) return false
        firstAidCount--
        health += (maxHealth * 3 / 10)
        if (health > maxHealth) health = maxHealth
        return true
    }


    private fun completeTurn(successAttack: Boolean, finishRound: Boolean) {
        when (turnOwner.id) {
            MARIO_ID -> ui.animateMario(Mario.attack(), false) {
                ui.animateMario(Mario.default(), true) {}
            }
//            GOOMBA_ID -> ui.animateGoomba()
//            BOWSER_ID -> ui.animateBowser()
        }
        if (successAttack) {
            if (getOpponent().id == GOOMBA_ID)
                ui.animateGoomba(Goomba.damage(), false) {
                    ui.animateGoomba(Goomba.default(), true) {}
                }
            else ui.animateBowser(Bowser.damage(), false) {
                ui.animateBowser(Bowser.default(), true) {}
            }
        }
        else if (getOpponent().id == GOOMBA_ID)
            ui.animateGoomba(Goomba.defense(), false) {
                ui.animateGoomba(Goomba.default(), true) {}
            }
        else ui.animateBowser(Bowser.defense(), false) {
            ui.animateBowser(Bowser.default(), true) {}
        }

        if (finishRound) {
            ui.animateMario(Mario.win(), false) {
                ui.animateMario(Mario.winLoop(), true) {}
            }
            if (getOpponent().id == GOOMBA_ID) ui.animateGoomba(Goomba.lose(), false) {
                start()
            }
            else ui.animateBowser(Bowser.lose(), false) {
                ui.animateBowser(Bowser.loseLoop(), true) {}
                start()
            }
        }
    }

    private fun selectLevel() {
//        soundPlayer.playMusic(ui!!, level)
//        ui?.selectLevel(level)
    }

    private fun getPlayer() : Player {
        return mario
    }

    private fun getMonster() : Monster? {
        return when (level) {
            1 -> goomba
            2 -> bowser
            else -> null
        }
    }

    private fun getOpponent() : Creature {
        return if (turnOwner.id == MARIO_ID) getMonster()!!
        else getPlayer()
    }

    private fun switchTurnOwner() { // переключить ход
        turnOwner = getOpponent()
//        turnOwner = if (turnOwner.id == MARIO_ID) getMonster()!!//.id
//        else mario//MARIO_ID
    }

    private fun opponentInDefense(creature: Creature) {
        //getOpponent
    }

    private fun rollTheDice() : Int {
        return (1..settings.diceFaces).random()
    }

    private fun attackSuccess(modifier: Int) : Boolean {
        var i = 0
        while (i < modifier) {
            if (rollTheDice() in settings.successfulAttack) return true
            i++
        }
        return false
    }

    private fun finishRound() {
        if (turnOwner.id == MARIO_ID) win()
        else lose()
    }

    private fun win() {
        if (level > 1) congrats()
        else nextLevel()
    }

    private fun lose() {

    }


    private fun nextLevel() {
        level++
    }

    private fun congrats() {

    }




}