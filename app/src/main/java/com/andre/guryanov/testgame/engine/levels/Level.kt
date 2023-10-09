package com.andre.guryanov.testgame.engine.levels

import com.andre.guryanov.testgame.engine.Animator
import com.andre.guryanov.testgame.engine.Game
import com.andre.guryanov.testgame.engine.SoundPlayer
import com.andre.guryanov.testgame.engine.UiManager
import com.andre.guryanov.testgame.models.Creature
import com.andre.guryanov.testgame.models.MonsterGoomba
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

abstract class Level {

    abstract val enemy: Creature?
    abstract val bgImages: Array<Int>
    abstract val bgSound: Int

    fun startLevelSwitching() {
        CoroutineScope(Dispatchers.IO).launch {
            SoundPlayer.stopWithEffect()
            UiManager.startScreenDimming(120L) {}
            withContext(Dispatchers.Main) {
                UiManager.invisibleAllViews()
                Animator.stopAllAnimations()

                prepareLevel()
                SoundPlayer.playWithEffect(UiManager.context(), bgSound)
            }

            UiManager.startScreenBrightening(120L) {}
            withContext(Dispatchers.Main) {
                launchLevel()
                UiManager.selectLevel(current)
            }
        }.invokeOnCompletion {

        }
    }

    abstract fun prepareLevel()

    abstract fun launchLevel()


    companion object {

        const val TITLE = 0
        const val GOOMBA = 1
        const val BOWSER = 2
        const val CONGRATS = 3

        var current = 0
            private set

        fun next() : Level {
            current++
            if (current > 3) current = 0
            return getLevel()
        }

        fun select(level: Int) : Level {
            current = level
            return getLevel()
        }

        private fun getLevel() : Level {
            return when (current) {
                GOOMBA -> LevelGoomba()
                BOWSER -> LevelBowser()
                CONGRATS -> Congrats()
                else -> Title()
            }
        }
    }
}