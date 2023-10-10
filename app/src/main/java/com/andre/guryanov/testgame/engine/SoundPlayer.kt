package com.andre.guryanov.testgame.engine

import android.content.Context
import android.media.MediaPlayer
import android.util.Log
import androidx.core.net.toUri
import com.andre.guryanov.testgame.R
import kotlinx.coroutines.*

object SoundPlayer {

    const val SFX_PAUSE = R.raw.game_pause

    private var music: MediaPlayer? = null
    private var lastMusicId: Int? = null
    private val intervalVolChanges: Long = 100  // периодичность изменения громкости при эффектах (в миллисек)
    private val freqVolChanges: Int = 19  // кол-во изменений громкости при эффектах

    var musicVolume: Float = 0.8f
        private set
    var sfxVolume: Float = 1f
        private set
    var enableMusic = true
        private set
    var enableSFX = true
        private set
    val sfxDelay = 10L


    init {
        // загрузить параметры, если есть
    }


    fun playMusic(context: Context, resId: Int) {
        lastMusicId = resId
        music = MediaPlayer.create(context, resId)
        play()
    }

    fun playWithEffect(context: Context, resId: Int) {
        lastMusicId = resId
        music = MediaPlayer.create(context, resId)
        music?.setVolume(0f, 0f)
        CoroutineScope(Dispatchers.IO).launch {
            play(false)
            amplificationEffect()
        }
    }

    fun stopWithEffect() {
        if (music?.isPlaying!!) {
            CoroutineScope(Dispatchers.IO).launch {
                attenuationEffect()
            }
        }
    }


    private fun play(default: Boolean = true) {
        if ( ! enableMusic) return
        if (default) music?.setVolume(musicVolume, musicVolume)
        music?.start()
        music?.isLooping = true
    }

    private fun stop() {
        music?.stop()
        music?.reset()
    }

    fun pause() {
        if (enableMusic) music?.pause()
    }

    fun resume() {
        if (enableMusic) music?.start()
    }

    fun playSFX(context: Context, resId: Int, delay: Long = sfxDelay, callback: () -> Unit) {
        if ( ! enableSFX) return

        CoroutineScope(Dispatchers.IO).launch {
            val sfx = MediaPlayer.create(context, resId)
            sfx.setOnCompletionListener {
                sfx.stop()
                sfx.reset()
//            callback()
            }
            sfx.setVolume(sfxVolume, sfxVolume)
            delay(delay)
            sfx.start()
        }
    }

    fun enableMusic(context: Context, state: Boolean) {
        if (state == enableMusic) return
        enableMusic = state
        if (enableMusic) {
            music = MediaPlayer.create(context, lastMusicId!!)
            play()
        }
        else stop()//music?.stop()
    }

    fun enableSFX(state: Boolean) {
        enableSFX = state
    }

    fun setMusicVolume(vol: Float) : Boolean {
        return if (vol in 0f..1f) {
            musicVolume = vol
            true
        }
        else false
    }

    fun setSfxVolume(vol: Float) : Boolean {
        return if (vol in 0f..1f) {
            sfxVolume = vol
            true
        }
        else false
    }

    private suspend fun attenuationEffect() { // эффект затухания музыки
        for (i in 1..freqVolChanges) {
            val diffVol = i * musicVolume / freqVolChanges
            val vol = musicVolume - diffVol
            music?.setVolume(vol, vol)
            delay(intervalVolChanges)
        }
        stop()
    }

    private suspend fun amplificationEffect() {   // эффект усиления громкости
        for (i in freqVolChanges downTo 1) {
            val diffVol: Float = i * musicVolume / freqVolChanges
            val vol = musicVolume - diffVol
            music?.setVolume(vol, vol)
            delay(intervalVolChanges)
        }
        music?.setVolume(musicVolume, musicVolume)
    }

}