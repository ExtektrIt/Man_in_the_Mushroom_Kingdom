package com.andre.guryanov.testgame.engine

import com.andre.guryanov.testgame.engine.levels.Level
import com.andre.guryanov.testgame.engine.levels.Title
import com.andre.guryanov.testgame.models.Creature
import com.andre.guryanov.testgame.models.PlayerMario
import kotlinx.coroutines.*

object Game {

    private var mario: PlayerMario? = null
    private var monster: Creature? = null

    lateinit var controller: Controller

    private var turnOwner: Creature? = null
    private var level: Level = Title()
    var isPlaying = false
        private set


    fun launchGame() {
        isPlaying = true
        level.prepareLevel()
        SoundPlayer.playMusic(UiManager.context(), level.bgSound)
    }

    fun setMario(newMario: PlayerMario?) {
        mario = newMario
    }

    fun start() {
        controller.lockActionButtons()
        level = Level.next()
        level.startLevelSwitching()
        monster = level.enemy
    }

    fun startDancing() {
        turnOwner = mario
        mario?.animAppearance {}?.invokeOnCompletion {
            mario?.animDefaultLoop()
        }
    }

    fun pause() {
        SoundPlayer.pause()
        SoundPlayer.playSFX(UiManager.context(), SoundPlayer.SFX_PAUSE) {}

        isPlaying = false
    }

    fun resume() {
        if ( !isPlaying ) SoundPlayer.playSFX(UiManager.context(), SoundPlayer.SFX_PAUSE) {}
        SoundPlayer.resume()
    }

    fun load() {

    }

    fun save() {

    }

    fun restartLevel() {

    }

    fun refreshHealth() {
        UiManager.playerHealth().text = mario?.health.toString()
        UiManager.monsterHealth().text = monster?.health.toString()
        UiManager.firstAid().text = mario?.firstAidCount.toString()
    }

    fun attack() {
        controller.lockActionButtons()
        val opponent = getOpponent()
        val success = turnOwner?.attack(opponent)
        val opponentIsAlive = opponent.health > 0

        val jobOwner = turnOwner!!.animAttack { }
        val jobOpponent = if (success!!) opponent.animDamage { }
        else opponent.animDefense { }

        completeTurn(jobOwner, jobOpponent, opponentIsAlive)
    }

    fun healPlayer() {
        if (mario!!.heal()) {
            controller.lockActionButtons()
            mario?.animHeal {}?.invokeOnCompletion {
                CoroutineScope(Dispatchers.Main).launch {
                    controller.unlockActionButtons()
                    mario?.animDefaultLoop()
                    refreshHealth()
                }
            }
        }
    }


    private fun completeTurn(jobOwner: Job, jobOpponent: Job, opponentIsAlive: Boolean) {
        if (opponentIsAlive) {
            CoroutineScope(Dispatchers.IO).launch {
                jobOwner.join()

                turnOwner!!.animDefaultLoop()
                jobOpponent.join()
                getOpponent().animDefaultLoop()
                withContext(Dispatchers.Main) {
                    refreshHealth()
                }
            }.invokeOnCompletion {
                switchTurnOwner()
            }
        }
        else {
            controller.lockActionButtons()
            CoroutineScope(Dispatchers.IO).launch {
                jobOwner.join()
                turnOwner!!.animWin {}.invokeOnCompletion {
                    if (turnOwner !is PlayerMario) {
                        turnOwner!!.animWinLoop()
                    }
                }
                jobOpponent.join()
                getOpponent().animLose {}.invokeOnCompletion {
                    getOpponent().animLoseLoop()
                }
                withContext(Dispatchers.Main) {
                    refreshHealth()
                }
                delay(3_500L)
            }.invokeOnCompletion {
                if (turnOwner is PlayerMario) win()
                else lose()
            }
        }
    }

    private fun getOpponent() : Creature {
        return if (turnOwner is PlayerMario) monster!!
        else mario!!
    }

    private fun switchTurnOwner() { // переключить ход
        CoroutineScope(Dispatchers.Main).launch {
            turnOwner = getOpponent()
            if (turnOwner !is PlayerMario) {
                controller.lockActionButtons()
                startAi().invokeOnCompletion {
                    attack()
                }
            }
            else {
                controller.unlockActionButtons()
            }

        }
    }

    private fun startAi() : Job {
        return CoroutineScope(Dispatchers.IO).launch {
            delay(Settings.turnLength.random())
        }
    }

    private fun win() {
        val j = CoroutineScope(Dispatchers.IO).launch {
            var job: Job? = null
            for (i in 1..5) {
                job = mario?.animWinShots()
                job?.join()
            }
        }
        j.invokeOnCompletion {
            start()
        }
    }

    private fun lose() {
        finish()
    }

    fun finish() {
        controller.lockActionButtons()
        mario = null
        level = Level.select(Level.TITLE)
        level.startLevelSwitching()
    }

}